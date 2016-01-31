package dao;

import java.util.List;

import model.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("transaction")
public class TransactionImpl implements TransactionDao {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void add(Transaction transaction) {
		Session session = sessionFactory.openSession();
		session.save(transaction);
		
//		org.hibernate.Transaction tx = session.getTransaction();
//		try {
//			tx.begin();
//			session.save(transaction);
//			tx.commit();
//		} catch (Exception e) {
//			tx.rollback();
//			System.err.println(e.getMessage());
//		} finally {
//			session.close();
//		}
	}

	@Transactional
	public void delete(Integer id) {
		Session session = sessionFactory.openSession();
		session.delete(this.getById(id));
		
//		org.hibernate.Transaction tx = session.getTransaction();
//		try {
//			tx.begin();
//			session.delete(this.getById(id));
//			tx.commit();
//		} catch (Exception e) {
//			tx.rollback();
//			System.err.println(e.getMessage());
//		} finally {
//			session.close();
//		}
	}

	public Transaction getById(Integer id) {
		Session session = sessionFactory.openSession();
		Transaction tx = (Transaction) session.get(Transaction.class, id);
		session.close();
		return tx;
	}

	@Transactional
	public void update(Transaction transaction) {
		Session session = sessionFactory.openSession();
		session.update(transaction);
		
//		org.hibernate.Transaction tx = session.getTransaction();
//
//		try {
//			tx.begin();
//			session.update(transaction);
//			tx.commit();
//		} catch (Exception e) {
//			tx.rollback();
//			System.err.println(e.getMessage());
//		} finally {
//			session.close();
//		}
	}

	@SuppressWarnings("unchecked")
	public List<Transaction> getAll() {
		Session session = sessionFactory.openSession();
		List<Transaction> tx = session.createQuery("from Transaction").list();
		session.close();
		return tx;
	}

	@SuppressWarnings("unchecked")
	public List<Transaction> getAllByIdCompte(Integer idcompte) {
		Session session = sessionFactory.openSession();
		List<Transaction> tx = session.createQuery("from Transaction t where t.compte.idcompte = '" + idcompte + "'").list();
		session.close();
		return tx;
	}

}
