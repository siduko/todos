package com.todos.webapp.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class MongoUserDetailsService implements UserDetailsService {

	private org.springframework.security.core.userdetails.User userdetails;
	@Resource
	private UserRepository userRepository;

	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		com.todos.webapp.models.User user = userRepository
				.findByUserName(username);
		userdetails = new org.springframework.security.core.userdetails.User(
				user.getUserName(), user.getPassword(), enabled,
				accountNonExpired, credentialsNonExpired, accountNonLocked,
				getAuthorities(user.getPermission()));
		return userdetails;
	}

	public List<GrantedAuthority> getAuthorities(String permisstion) {
		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
		authList.add(new SimpleGrantedAuthority(permisstion));
		return authList;
	}

}
