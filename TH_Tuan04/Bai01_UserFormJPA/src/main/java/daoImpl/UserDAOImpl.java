package daoImpl;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import dao.UserDAO;
import entities.User;
import utils.EntityManagerFactoryUtil;

@SuppressWarnings("unchecked")
public class UserDAOImpl implements UserDAO {

	private EntityManager entityManager;

	public UserDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public User save(User user) {
		EntityTransaction transaction = null;
		try {
			transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(user);
			transaction.commit();
			return user;
		} catch (Exception e) {
			e.printStackTrace();

			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
		}

		return null;
	}

	@Override
	public User update(User user) {
		EntityTransaction transaction = null;
		try {
			transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.merge(user);
			transaction.commit();
			return user;
		} catch (Exception e) {
			e.printStackTrace();

			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
		}
		return null;
	}

	@Override
	public List<User> findAll() {
		try {
			return entityManager.createQuery("FROM User").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
