package com.bjit.authenticationdemo.demoauthentication.service.implementation;

import com.bjit.authenticationdemo.demoauthentication.model.AuthenticationRequestModel;
import com.bjit.authenticationdemo.demoauthentication.model.AuthenticationResponseModel;
import com.bjit.authenticationdemo.demoauthentication.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepo;
    private final AuthenticationManager authManager;
    public AuthenticationResponseModel login(AuthenticationRequestModel authRequest){

    }
}
