package Back_End.Util;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;

public class ReviewDAO {
	SessionFactory sessionFactory;
	
	public ReviewDAO() {
		super();
	}
	
	public void insert(Review review) {
		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		session.save(review);
		trans.commit();
		session.close();
	}
	
	public void update(Review review) {
		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		session.update(review);
		trans.commit();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Review> list(){
		
		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(Review.class);
		cr.addOrder(Order.asc("id"));
		return cr.list();
	}
	
	public Review finReviewByID(int id) {
		
		Session session = sessionFactory.openSession();
		Review review = (Review) session.get(Review.class, id);
		
		return review;
	}
	
	
}
