package hobup.core.db.access;

import hobup.core.db.access.data.MsAccessCategory;
import hobup.core.db.access.data.MsAccessData;
import hobup.core.db.access.data.MsAccessMainCategory;
import hobup.core.db.access.data.MsAccessSubCategory;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.google.common.collect.ImmutableSet;

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
		MsAccessMainCategory msAccessMainCategory = (MsAccessMainCategory) session
				.load(MsAccessMainCategory.class, 1);
		msAccessMainCategory.setDescription(new Date().toString());
		session.saveOrUpdate(msAccessMainCategory);
	}

	private static void readAllTables(Session session) {
		ImmutableSet<Class<? extends MsAccessData>> tableNames = new ImmutableSet.Builder<Class<? extends MsAccessData>>()
				.add(MsAccessMainCategory.class)
				.add(MsAccessCategory.class)
				.add(MsAccessSubCategory.class)
				.build();

		for (Class<? extends MsAccessData> tableName : tableNames) {
			for (MsAccessData data : getDataFromTable(
					session,
					tableName)) {
				System.out.println(data.toString());
			}
		}
	}

	private static <T> List<T> getDataFromTable(Session session,
			Class<T> dataTypeClass) {
		// Criteria Query Example
		// session.crea
		Criteria crit = session.createCriteria(dataTypeClass);
		@SuppressWarnings("unchecked")
		List<T> list = crit.list();
		return list;
	}
}
