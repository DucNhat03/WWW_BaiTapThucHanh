package dao;

import java.util.List;

import entities.Product;

public interface Product_DAO {
	public List<Product> findAll();
	public Product getById(String id);
	public void addProduct(Product p);
}
