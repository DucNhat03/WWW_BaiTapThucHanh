package daoImpl;

import jakarta.persistence.EntityManager;
import model.TinTuc;
import java.util.List;
import dao.TinTucDAO;


public class TinTucDAOImpl implements TinTucDAO {

    private EntityManager entityManager;

    public TinTucDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    @Override
	public List<TinTuc> getAllTinTuc() {
	    try {
	        entityManager.getTransaction().begin();
	        List<TinTuc> products = entityManager.createQuery("FROM TinTuc", TinTuc.class).getResultList();
	        entityManager.getTransaction().commit();
	        return products;
	    } catch (Exception e) {
	        if (entityManager.getTransaction().isActive()) {
	            entityManager.getTransaction().rollback();
	        }
	        e.printStackTrace();
	    }
	    return null;
	}

    @Override
    public List<TinTuc> getTinTucByDanhMuc(int maDM) {
        try {
            entityManager.getTransaction().begin();
            List<TinTuc> tinTucList = entityManager
                .createQuery("FROM TinTuc WHERE maDM = :maDM", TinTuc.class)
                .setParameter("maDM", maDM)
                .getResultList();
            entityManager.getTransaction().commit();
            return tinTucList;
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addTinTuc(TinTuc tinTuc) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(tinTuc);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTinTuc(int maTT) {
        try {
            entityManager.getTransaction().begin();
            TinTuc tinTuc = entityManager.find(TinTuc.class, maTT);
            if (tinTuc != null) {
                entityManager.remove(tinTuc);
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
