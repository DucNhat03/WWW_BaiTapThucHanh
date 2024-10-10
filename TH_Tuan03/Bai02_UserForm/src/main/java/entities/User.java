package entities;

public class User {
	private String  firstName, lastName, email, passWord, birthDay;
	private boolean gioiTinh;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String firstName, String lastName, String email, String passWord, String birthDay, boolean gioiTinh) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.passWord = passWord;
		this.birthDay = birthDay;
		this.gioiTinh = gioiTinh;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	@Override
	public String toString() {
		return "user [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", passWord=" + passWord
				+ ", birthDay=" + birthDay + ", gioiTinh=" + gioiTinh + "]";
	}
}
