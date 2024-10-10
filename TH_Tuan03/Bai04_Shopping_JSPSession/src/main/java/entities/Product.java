package entities;

public class Product {
	private String id, name;
	private double price;
	private String img;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(String id, String name, double price, String img) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.img = img;
	}

	public Product(String name, double price, String img) {
		super();
		this.name = name;
		this.price = price;
		this.img = img;
	}

	public Product(String id) {
		super();
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", img=" + img + "]";
	}
}
