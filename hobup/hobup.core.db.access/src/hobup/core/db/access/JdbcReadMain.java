package hobup.core.db.access;

import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.google.common.base.Objects;
import com.google.common.collect.ImmutableSet;

public class JdbcReadMain {

	public static void main(String[] args) throws Exception {
		Class.forName("com.hxtt.sql.access.AccessDriver").newInstance();
		String url = "jdbc:access:/db.accdb";
		Connection conn = DriverManager.getConnection(url);

		readAllTables(conn);

		conn.close();
	}

	private static void readAllTables(Connection conn)
			throws TransformerException, ParserConfigurationException,
			SQLException, TransformerFactoryConfigurationError,
			TransformerConfigurationException {
		ImmutableSet<String> tableNames = ImmutableSet.of("Podkategorie");
		// "KategorieGlowne","Kategorie");

		for (String tableName : tableNames) {
			System.out.println(xmlToString(getDataFromTable(conn, tableName)));
			System.out.println();
		}
	}

	private static Document getDataFromTable(Connection conn, String tableName)
			throws ParserConfigurationException, SQLException,
			TransformerFactoryConfigurationError,
			TransformerConfigurationException, TransformerException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.newDocument();
		Element results = doc.createElement("Results");
		doc.appendChild(results);

		ResultSet rs = conn.createStatement().executeQuery(
				"SELECT * FROM " + tableName);

		ResultSetMetaData rsmd = rs.getMetaData();
		int colCount = rsmd.getColumnCount();

		while (rs.next()) {
			Element row = doc.createElement("Row");
			results.appendChild(row);
			for (int i = 1; i <= colCount; i++) {
				String columnName = rsmd.getColumnName(i);
				String columnTypeName = rsmd.getColumnTypeName(i);
				Object value = rs.getObject(i);
				Element node = doc.createElement(columnName);
				node.appendChild(doc.createTextNode(Objects.firstNonNull(value,
						"").toString()));
				node.setAttribute("type", columnTypeName);
				row.appendChild(node);
			}
		}
		return doc;
	}

	private static String xmlToString(Node doc) throws TransformerException {
		DOMSource domSource = new DOMSource(doc);
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformer = tf.newTransformer();
		transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		// transformer.setOutputProperty(OutputKeys.METHOD, "xml");
		transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
		StringWriter sw = new StringWriter();
		StreamResult sr = new StreamResult(sw);
		transformer.transform(domSource, sr);
		return sw.toString();
	}
}
