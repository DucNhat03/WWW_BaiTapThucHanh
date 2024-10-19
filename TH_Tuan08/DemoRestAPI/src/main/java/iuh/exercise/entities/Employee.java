package iuh.exercise.entities;

import java.sql.Date;
import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "first_name")
	@NotNull(message = "First Name must not be Null")
	@NotEmpty(message = "First Name must not be Empty")
	private String firstName;
	@Column(name = "last_name")
	@NotNull(message = "Last Name must not be Null")
	@NotEmpty(message = "Last Name must not be Empty")
	private String lastName;
	private String gender;
	@Column(name = "email")
	@NotEmpty(message = "Email must not be Empty")
	@Email(message = "Email should be valid")
	private String emailAddress;
	@Column(name = "phone_number")
	@Pattern(regexp = "\\(\\d{3}\\)\\d{3}-\\d{4}", message = "Please input phone number with format: (NNN)NNN-NNNN")
	private String phoneNumber;

	@Past(message = "Date of birth must be less than today")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob; // Thay đổi từ Date sang LocalDate

	@CreationTimestamp
	@Column(name = "created_date")
	private LocalDate createdDate; // Thay đổi từ Date sang LocalDate

	@UpdateTimestamp
	@Column(name = "modified_date")
	private LocalDate modifiedDate; // Thay đổi từ Date sang LocalDate

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "address_id", referencedColumnName = "id")
	@JsonIgnore
	private Address address;

	public Employee() {
	}

	public Employee(String firstName, String lastName, String gender, String emailAddress, String phoneNumber,
			LocalDate dob, Address address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
		this.dob = dob;
		this.address = address;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDate getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(LocalDate modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
				+ ", emailAddress=" + emailAddress + ", phoneNumber=" + phoneNumber + ", dob=" + dob + ", createdDate="
				+ createdDate + ", modifiedDate=" + modifiedDate + ", address=" + address + "]";
	}

}