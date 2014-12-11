package com.todos.webapp.models;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class User {
	@NotEmpty
	@NotNull
	private String userName;

	@NotEmpty
	@NotNull
	private String password;
	private String address;
	private String firstName;
	private String lastName;
	private String phone;
	private boolean receiveNewsletter;

	public User() {
	}

	public User(String userName, String password, String address,
			String firstName, String lastName, String phone,
			boolean receiveNewsletter) {
		super();
		this.userName = userName;
		this.password = password;
		this.address = address;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.receiveNewsletter = receiveNewsletter;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isReceiveNewsletter() {
		return receiveNewsletter;
	}

	public void setReceiveNewsletter(boolean receiveNewsletter) {
		this.receiveNewsletter = receiveNewsletter;
	}

	public interface IUserService {

		public abstract long countAllUsers();

		public abstract void deleteUser(User user);

		public abstract User findUser(String id);

		public abstract List<User> findAllUsers();

		public abstract List<User> findUserEntries(int firstResult, int maxResults);

		public abstract User findByUsername(String username);

		public abstract void saveUser(User user);

		public abstract User updateUser(User user);

		public abstract List<User> getUserRoles(String id);

	}

}
