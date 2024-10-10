package daoImpl;

import jakarta.persistence.EntityManager;
import model.Product;
import java.util.List;

import dao.ProductDAO;
import utils.EntityManagerFactoryUtil;

public class ProductDAOImpl implements ProductDAO {

	private EntityManager entityManager;
	

	public ProductDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Product> getAllProducts() {
	    try {
	        entityManager.getTransaction().begin();
	        List<Product> products = entityManager.createQuery("FROM Product", Product.class).getResultList();
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
	public Product findProductById(int id) {
		try {
			Product product = entityManager.find(Product.class, id);
			return product;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}