package com.claim.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="photographer")
public class Photographer {

	@Id
	@Column (name="email")
	private String email;
	
	@Column (name="user_name")
	private String userName; 
	
	@Column (name="password")
	private String password; 
	
	@Column (name="first_name")
	private String firstName; 
	
	@Column (name="last_name")
	private String lastName; 
	
	@Column (name="age")
	private String age; 
	
	@Column (name="telephone")
	private String telephone;
	
	@Column (name= "profile")
	private byte[] profile;
	
	@Column (name= "about_me")
	private String aboutMe;
	
	@OneToOne(cascade =CascadeType.ALL)
	@JoinColumn(name="address_id")
	private Address address;

	
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public byte[] getProfile() {
		return profile;
	}
	
	public void setProfile(byte[] profile) {
		this.profile = profile;
	}
	public String getAboutMe() {
		return aboutMe;
	}
	
	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}
	

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	
	


}
