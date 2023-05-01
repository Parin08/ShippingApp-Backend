package com.example.ShoppingCenter.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/*{
    "userId": 123123,
    "city": "Ahmedabad",
    "country": "India",
    "email": "parinpatel@gmail.com",
    "name": "Parin Patel",
    "password": "3cfe170c$",
    "streetName": "Sureshwari road",
    "streetNumber": 205,
    "unitNumber": 10,
    "username": "Pate0468",
    "province":"Ontario"
   
}*/

@Entity
public class User {

	@Id
	private int userId;
	private String firstName;
	private String lastName;
	private String email;
	private String username;
	private String password;
	private int unitNumber;
	private String streetAddress;
	private String city;
	private String province;
	private String country;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUnitNumber() {
		return unitNumber;
	}

	public void setUnitNumber(int unitNumber) {
		this.unitNumber = unitNumber;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", username=" + username + ", password=" + password + ", unitNumber=" + unitNumber
				+ ", streetAddress=" + streetAddress + ", city=" + city + ", province=" + province + ", country="
				+ country + "]";
	}

}
