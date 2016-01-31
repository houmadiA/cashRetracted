package dao;

import java.util.ArrayList;
import java.util.List;

import model.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("user")
public class UserImpl implements UserDao {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void add(User user) {
		Session session = sessionFactory.openSession();
		session.save(user);

		// Transaction tx = session.getTransaction();
		// try {
		// tx.begin();
		// session.save(user);
		// tx.commit();
		// } catch (Exception e) {
		// tx.rollback();
		// System.err.println(e.getMessage());
		// } finally {
		// session.close();
		// }
	}

	@Transactional
	public void delete(Integer id) {
		Session session = sessionFactory.openSession();
		session.delete(this.getById(id));

		// Transaction tx = session.getTransaction();
		// try {
		// tx.begin();
		// session.delete(this.getById(id));
		// tx.commit();
		// } catch (Exception e) {
		// tx.rollback();
		// System.err.println(e.getMessage());
		// } finally {
		// session.close();
		// }
	}

	public User getById(Integer id) {
		Session session = sessionFactory.openSession();
		User user = (User) session.get(User.class, id);
		session.close();
		return user;
	}

	public void update(User user) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.getTransaction();
		try {
			tx.begin();
			session.update(user);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			System.err.println(e.getMessage());
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<User> getAll() {
		Session session = sessionFactory.openSession();
		List<User> users = session.createQuery("from User").list();
		session.close();
		return users;
	}

	@SuppressWarnings("unchecked")
	public User getByUsername(String username) {
		List<User> users = new ArrayList<User>();
		Session session = sessionFactory.openSession();
		users =session.createQuery("from User where username=?").setParameter(0, username).list();

		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}
	}
}
