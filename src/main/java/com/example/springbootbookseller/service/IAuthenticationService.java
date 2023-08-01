package com.example.springbootbookseller.service;

import com.example.springbootbookseller.model.User;

public interface IAuthenticationService {

	User signInAndReturnJWT(User signInRequest);

}
