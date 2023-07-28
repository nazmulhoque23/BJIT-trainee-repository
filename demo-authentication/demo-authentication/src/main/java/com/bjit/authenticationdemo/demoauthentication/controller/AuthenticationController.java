package com.bjit.authenticationdemo.demoauthentication.controller;

import com.bjit.authenticationdemo.demoauthentication.model.AuthenticationRequestModel;
import com.bjit.authenticationdemo.demoauthentication.model.UserResponseModel;
import com.bjit.authenticationdemo.demoauthentication.service.implementation.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class AuthenticationController {
    private final AuthenticationService authService;
    @PostMapping("/login")
    public ResponseEntity<UserResponseModel> login(@RequestBody AuthenticationRequestModel authRequest){
        return authService.login(authRequest);
    }
}
