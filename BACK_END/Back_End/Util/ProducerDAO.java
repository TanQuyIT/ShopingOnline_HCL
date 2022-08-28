package Back_End.Util;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;

public class ProducerDAO {
	SessionFactory sessionFactory;
	
	public public ProducerDAO() {
		// TODO Auto-generated constructor stub
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	public void insert(Producer producer) {
		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		session.save(producer);
		trans.commit();
		session.close();
	}
	
	public void update(Producer producer) {
		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		session.update(producer);
		trans.commit();
		session.close();
	}
	

	@SuppressWarnings("unchecked")
	public List<Producer> list(){
		
		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(Producer.class);
		cr.addOrder(Order.asc("id"));
		return cr.list();
	}
	
	public Producer finProducerByID(int id) {
		
		Session session = sessionFactory.openSession();
		Producer producer = (Producer) session.get(Producer.class, id);
		
		return producer;
	}
	
}
