package Back_End.Util;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;


public class CategoryDAO {
	SessionFactory sessionFactory;
	
	public CategogryDAO() {
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	
	public void insert(Categogry categogry) {
		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		session.save(categogry);
		trans.commit();
		session.close();
	}
	
	public void update(Categogry categogry) {
		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		session.update(categogry);
		trans.commit();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Categogry> list(){
		
		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(Categogry.class);
		cr.addOrder(Order.asc("id"));
		return cr.list();
	}
	
	public Categogry findCategogryByID(int id) {
		Categogry categogry = null;
		Session session = sessionFactory.openSession();
		categogry = (Categogry) session.get(Categogry.class, id);
		
		return categogry;
	}
}
