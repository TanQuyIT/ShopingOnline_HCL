package Back_End.Util;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;


public class ItemDAO {
	SessionFactory sessionFactory;
	
	public ItemDAO() {
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	public void insert(Item item) {
		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		session.save(item);
		trans.commit();
		session.close();
	}
	
	public void update(Item item) {
		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		session.update(item);
		trans.commit();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Item> list(){
		
		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(Item.class);
		cr.addOrder(Order.asc("id"));
		return cr.list();
	}
	
	public Item findItemById(int id) {
		Categogry categogry = null;
		Session session = sessionFactory.openSession();
		categogry = (Categogry) session.get(Item.class, id);
		
		return categogry;
	}
	
}
