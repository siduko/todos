package com.todos.webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import com.todos.webapp.models.User;

public interface UserRepository extends CrudRepository<User , String> {
	User findByUserNameAndPassword(String userName,String password);
	User findByUserName(String userName);
}
