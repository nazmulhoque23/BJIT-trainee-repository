package com.bjitacademy.booklibrary.onlinebooklibrary.model;

import com.bjitacademy.booklibrary.onlinebooklibrary.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequestModel {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String address;
    private List<String> roles;

}
