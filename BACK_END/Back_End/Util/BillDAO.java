package Back_End.Util;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;

public class BillDAO {
	SessionFactory sessionFactory;
	
	public BillDAO() {
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	public void insert(Bill bill) {
		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		session.save(bill);
		trans.commit();
		session.close();
	}
	
	public void update(Bill bill) {
		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		session.update(bill);
		trans.commit();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Bill> list(){
		
		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(Bill.class);
		cr.addOrder(Order.asc("id"));
		return cr.list();
	}
	
	public Bill findBillByID(int id) {
		Session session = sessionFactory.openSession();
		Bill bill = (Bill) session.get(Bill.class, id);
		
		return bill;
	}
}
