package iuh.exercise.entities;

public class Address {
	private String city;
	private String street;
	private String country;

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(String city, String street, String country) {
		super();
		this.city = city;
		this.street = street;
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address [city=" + city + ", street=" + street + ", country=" + country + "]";
	}

}
