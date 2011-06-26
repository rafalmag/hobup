package hobup.core.db.access;

import hobup.core.db.access.data.MsAccessCategory;
import hobup.core.db.access.data.MsAccessData;
import hobup.core.db.access.data.MsAccessSubCategory;

import java.util.Date;
import java.util.List;
import java.util.Map.Entry;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.google.common.collect.ImmutableMap;

public class HibernateReadMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();

		updateDesc(session);

		readAllTables(session);
		session.close();
	}

	private static void updateDesc(Session session) {
		MsAccessCategory msAccessMainCategory = (MsAccessCategory) session
				.load("MainCategory", 1);
		msAccessMainCategory.setDescription(new Date().toString());
		session.saveOrUpdate("MainCategory", msAccessMainCategory);
	}

	private static void readAllTables(Session session) {
		ImmutableMap<String, Class<? extends MsAccessData>> entityMap = new ImmutableMap.Builder<String, Class<? extends MsAccessData>>()
				.put("MainCategory", MsAccessCategory.class)
				.put("Category", MsAccessCategory.class)
				.put("SubCategory", MsAccessSubCategory.class)
				.build();

		for (Entry<String, Class<? extends MsAccessData>> entity : entityMap
				.entrySet()) {
			for (MsAccessData data : getDataFromTable(
					session,
					entity.getKey())) {
				System.out.println(data.toString());
			}
		}
	}

	private static <T extends MsAccessData> List<T> getDataFromTable(
			Session session, String entity) {
		// Criteria Query Example
		// session.crea
		Criteria crit = session.createCriteria(entity);
		@SuppressWarnings("unchecked")
		List<T> list = crit.list();
		return list;
	}
}
