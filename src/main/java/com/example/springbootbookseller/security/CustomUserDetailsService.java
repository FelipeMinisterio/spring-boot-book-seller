package com.example.springbootbookseller.security;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.springbootbookseller.model.User;
import com.example.springbootbookseller.service.IUserService;
import com.example.springbootbookseller.util.SecurityUtils;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private IUserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));

		Set<GrantedAuthority> authorities = Set.of(SecurityUtils.convertToAuthority(user.getRole().name()));
		
		return UserPrincipal.builder()
				.user(user).id(user.getId()).username(user.getUsername()).password(user.getPassword())
				.authorities(authorities)
				.build(); 
	}

}
