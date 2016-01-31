package dao;

import java.util.List;

import model.Compte;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("compte")
public class CompteImpl implements CompteDao {

	
	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	@Transactional
	public void add(Compte compte) {
		Session session = sessionFactory.openSession();
		session.save(compte);

	}

	@Override
	@Transactional
	public void delete(Integer id) {
		Session session = sessionFactory.openSession();
		session.delete(this.getById(id));

	}

	@Override
	public Compte getById(Integer id) {
		Session session = sessionFactory.openSession();
		Compte compte = (Compte) session.get(Compte.class, id);
		session.close();
		return compte;
	}

	@Override
	public void update(Compte compte) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.getTransaction();
		try {
			tx.begin();
			session.update(compte);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			System.err.println(e.getMessage());
		} finally {
			session.close();
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Compte> getAll() {
		Session session = sessionFactory.openSession();
		List<Compte> comptes = session.createQuery("from Compte").list();
		session.close();
		return comptes;
	}

}
