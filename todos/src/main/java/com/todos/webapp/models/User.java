package com.todos.webapp.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="users")
public class User {
	@Id
	@NotEmpty
	@NotNull
	private String userName;

	@NotEmpty
	@NotNull
	private String password;
	
	@NotEmpty
	private String address;
	
	@NotEmpty
	private String fullName;
	
	@Pattern(regexp="0[0-9]{9,11}|\\+[0-9]{9,12}")
	private String phone;
	
	@Pattern(regexp="[0-9a-zA-Z]+[._]?[0-9a-zA-Z]+@[0-9a-zA-Z]+\\.[0-9a-zA-Z]+")
	private String email;
	
	private String permission;

	public User() {
		this.userName = "";
		this.password = "";
		this.address = "";
		this.fullName = "";
		this.phone = "";
		this.email = "";
		this.permission = "user";
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}
	
	

}
