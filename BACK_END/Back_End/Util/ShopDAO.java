package Back_End.Util;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;

public class ShopDAO {
	SessionFactory sessionFactory;
	
	public public ShopDAO() {
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	public void insert(Shop shop) {
		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		session.save(shop);
		trans.commit();
		session.close();
	}
	
	
	public void update(Shop shop) {
		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		session.update(shop);
		trans.commit();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Shop list(){
		
		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(Shop.class);
		cr.addOrder(Order.asc("id"));
		return cr.list();
	}
	
	public Shop finShopByID(int id) {
		
		Session session = sessionFactory.openSession();
		Shop shop = (Shop) session.get(Shop.class, id);
		
		return shop;
	}
}
