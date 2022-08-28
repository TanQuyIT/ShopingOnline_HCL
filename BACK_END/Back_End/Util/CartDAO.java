package Back_End.Util;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;

public class CartDAO {
	SessionFactory sessionFactory;
	
	public public CartDAO() {
		// TODO Auto-generated constructor stub
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	public void insert(Cart cart) {
		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		session.save(cart);
		trans.commit();
		session.close();
	}
	
	public void update(Cart cart) {
		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		session.update(cart);
		trans.commit();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Cart> list(){
		
		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(Cart.class);
		cr.addOrder(Order.asc("id"));
		return cr.list();
	}
	
	public Cart finCartByID(int id) {
		Session session = sessionFactory.openSession();
		Cart cart = (Cart) session.get(Cart.class, id);
		return cart;
	}
	
	
}
