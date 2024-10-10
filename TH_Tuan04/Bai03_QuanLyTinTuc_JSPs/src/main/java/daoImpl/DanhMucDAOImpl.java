package daoImpl;

import jakarta.persistence.EntityManager;
import model.DanhMuc;
import dao.DanhMucDAO;
import java.util.List;

public class DanhMucDAOImpl implements DanhMucDAO {

	private EntityManager entityManager;

	public DanhMucDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<DanhMuc> getAllDanhMuc() {
		try {
			entityManager.getTransaction().begin();
			List<DanhMuc> danhMucList = entityManager.createQuery("FROM DanhMuc", DanhMuc.class).getResultList();
			entityManager.getTransaction().commit();
			return danhMucList;
		} catch (Exception e) {
			if (entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().rollback();
			}
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void addDanhMuc(DanhMuc danhMuc) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(danhMuc);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			if (entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public void deleteDanhMuc(int maDM) {
		try {
			entityManager.getTransaction().begin();
			DanhMuc danhMuc = entityManager.find(DanhMuc.class, maDM);
			if (danhMuc != null) {
				entityManager.remove(danhMuc);
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
