package lab5.daoImpl;

import lab5.dao.DienThoaiDAO;
import lab5.model.DienThoai;

import java.util.List;

import jakarta.persistence.EntityManager;

public class DienThoaiDAOImpl implements DienThoaiDAO {

	private EntityManager entityManager;

	public DienThoaiDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<DienThoai> getAllDienThoai() {
		try {
			entityManager.getTransaction().begin();
			List<DienThoai> dienThoaiList = entityManager.createQuery("FROM DienThoai", DienThoai.class).getResultList();
			entityManager.getTransaction().commit();
			return dienThoaiList;
		} catch (Exception e) {
			if (entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().rollback();
			}
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public DienThoai getDienThoaiById(String maDT) {
		try {
			entityManager.getTransaction().begin();
			DienThoai dienThoai = entityManager.createQuery("FROM DienThoai WHERE MADT = :maDT", DienThoai.class)
					.setParameter("maDT", maDT).getSingleResult();
			entityManager.getTransaction().commit();
			return dienThoai;
		} catch (Exception e) {
			if (entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().rollback();
			}
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insertDienThoai(DienThoai dt) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(dt);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			if (entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public void updateDienThoai(DienThoai dt) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(dt);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			if (entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public void deleteDienThoai(String maDT) {
		try {
			entityManager.getTransaction().begin();
			DienThoai dt = entityManager.find(DienThoai.class, maDT);
			if (dt != null) {
				entityManager.remove(dt);
			}
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			if (entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().rollback();
			}
			e.printStackTrace();
		}
	}
}
