package daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import dao.Product_DAO;
import entities.Product;

public class Product_Implement implements Product_DAO{
	private DataSource data;
	
	public Product_Implement(DataSource data) {
		this.data = data;
	}
	
	@Override
	public List<Product> findAll() {
		String sql = "SELECT * FROM product";
		List<Product> list = new ArrayList<Product>();
		try (
				Connection con = this.data.getConnection();
				PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
		) {
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				Double price = rs.getDouble("price");
				String image = rs.getString("image");
				list.add(new Product(id, name, price, image));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Product getById(String id) {
		String sql = "SELECT * FROM product WHERE id=?";
		Product p = null;
		try (
				Connection con = this.data.getConnection();
				PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			){
			ps.setString(1, id);
			try (ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					String name = rs.getString("name");
					Double price = rs.getDouble("price");
					String image = rs.getString("image");
					p = new Product(id, name, price,image);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public void addProduct(Product p) {
		String sql = "INSERT INTO product (name, price, image) VALUES (?,?,?)";
		try (
				Connection con = this.data.getConnection();
				PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
		){
			ps.setString(1, p.getName());
			ps.setDouble(2, p.getPrice());
			ps.setString(3, p.getImg());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
