package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "userlist")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	protected int id;

	@Column(name = "firstName")
	@NotNull(message = "firstName must be not null")
	@NotEmpty(message = "firstName must be not empty")
	private String firstName;
	@Column(name = "lastName")
	@NotNull(message = "lastName must be not null")
	@NotEmpty(message = "lastName must be not empty")
	private String lastName;
	@Column(name = "email")
	@NotNull(message = "email must be not null")
	@NotEmpty(message = "email must be not empty")
	private String email;
	@Column(name = "passWord")
	@NotNull(message = "passWord must be not null")
	@NotEmpty(message = "passWord must be not empty")
	private String passWord;
	private String birthDay;
	private boolean gioiTinh;

	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public User(
			@NotNull(message = "firstName must be not null") @NotEmpty(message = "firstName must be not empty") String firstName,
			@NotNull(message = "lastName must be not null") @NotEmpty(message = "lastName must be not empty") String lastName,
			@NotNull(message = "email must be not null") @NotEmpty(message = "email must be not empty") String email,
			@NotNull(message = "passWord must be not null") @NotEmpty(message = "passWord must be not empty") String passWord,
			@NotNull(message = "birthDay must be not null") @NotEmpty(message = "birthDay must be not empty") String birthDay,
			@NotNull(message = "Name must be not null") @NotEmpty(message = "Name must be not empty") boolean gioiTinh) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.passWord = passWord;
		this.birthDay = birthDay;
		this.gioiTinh = gioiTinh;
	}

	public User(int id,
			@NotNull(message = "firstName must be not null") @NotEmpty(message = "firstName must be not empty") String firstName,
			@NotNull(message = "lastName must be not null") @NotEmpty(message = "lastName must be not empty") String lastName,
			@NotNull(message = "email must be not null") @NotEmpty(message = "email must be not empty") String email,
			@NotNull(message = "passWord must be not null") @NotEmpty(message = "passWord must be not empty") String passWord,
			@NotNull(message = "birthDay must be not null") @NotEmpty(message = "birthDay must be not empty") String birthDay,
			@NotNull(message = "Name must be not null") @NotEmpty(message = "Name must be not empty") boolean gioiTinh) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.passWord = passWord;
		this.birthDay = birthDay;
		this.gioiTinh = gioiTinh;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", passWord=" + passWord + ", birthDay=" + birthDay + ", gioiTinh=" + gioiTinh + "]";
	}

}
