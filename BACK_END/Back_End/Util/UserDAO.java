package Back_End.Util;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;


public class UserDAO {
	
	SessionFactory sessionFactory;
	
	public UserDAO() {
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	public void insert(User user) {
		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		session.save(user);
		trans.commit();
		session.close();
	}
	
	public void update(User user) {
		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		session.update(item);
		trans.commit();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<User> list(){
		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(Categogry.class);
		cr.addOrder(Order.asc("id"));
		return cr.list();
	}
	
	public User findUserByID(int id) {
		User user = null;
		Session session = sessionFactory.openSession();
		user = (User) session.get(User.class, id);
		
		return user;
	}
	
}
