package com.example.springbootbookseller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootbookseller.model.User;
import com.example.springbootbookseller.service.IAuthenticationService;
import com.example.springbootbookseller.service.IUserService;

@RestController
@RequestMapping("api/authentication")
public class AuthenticationController {

	@Autowired
	private IAuthenticationService authenticationService;

	@Autowired
	private IUserService userService;

	@PostMapping("sign-up")
	public ResponseEntity<User> signUp(@RequestBody User user) {
		if (userService.findByUsername(user.getUsername()).isPresent()) {
			return new ResponseEntity<User>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.CREATED);
	}

	@PostMapping("sign-in")
	public ResponseEntity<?> signIn(@RequestBody User user) {
 		return new ResponseEntity<User>(authenticationService.signInAndReturnJWT(user), HttpStatus.OK);
	}
}
