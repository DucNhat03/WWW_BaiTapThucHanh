package lab5.daoImpl;

import lab5.dao.NhaCungCapDAO;
import lab5.model.NhaCungCap;

import java.util.List;

import jakarta.persistence.EntityManager;

public class NhaCungCapDAOImpl implements NhaCungCapDAO {

	private EntityManager entityManager;

	public NhaCungCapDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<NhaCungCap> selectAllNhaCungCap() {
		try {
			entityManager.getTransaction().begin();
			List<NhaCungCap> danhMucList = entityManager.createQuery("FROM NhaCungCap", NhaCungCap.class)
					.getResultList();
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

}
