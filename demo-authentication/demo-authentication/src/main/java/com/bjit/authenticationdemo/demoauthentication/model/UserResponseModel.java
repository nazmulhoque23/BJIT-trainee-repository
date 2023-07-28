package com.bjit.authenticationdemo.demoauthentication.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponseModel {
    private String email;
    private String firstName;
    private String lastName;
}
