package com.bjit.authenticationdemo.demoauthentication.service.implementation;

import com.bjit.authenticationdemo.demoauthentication.entity.User;
import com.bjit.authenticationdemo.demoauthentication.model.UserRequestModel;
import com.bjit.authenticationdemo.demoauthentication.model.UserResponseModel;
import com.bjit.authenticationdemo.demoauthentication.repository.UserRepository;
import com.bjit.authenticationdemo.demoauthentication.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    //private UserMapper userMapper;


    @Override
    public ResponseEntity<Object> register(UserRequestModel userRequestModel){
        User user = User.builder()
                .userName(userRequestModel.getUserName())
                .email(userRequestModel.getEmail())
                .password(passwordEncoder.encode(userRequestModel.getPassword()))
                .firstName(userRequestModel.getFirstName())
                .lastName(passwordEncoder.encode(userRequestModel.getPassword()))
                .build();
        User savedUser = userRepository.save(user);
        UserResponseModel response = UserResponseModel.builder()
                                    .email(savedUser.getEmail())
                                    .firstName(savedUser.getFirstName())
                                    .lastName(savedUser.getLastName())
                                    .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> getUser(Integer id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            User requiredUser = user.get();
            UserResponseModel response = UserResponseModel
                                        .builder()
                                        .email(requiredUser.getEmail())
                                        .firstName(requiredUser.getFirstName())
                                        .lastName(requiredUser.getLastName())
                                        .build();
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Cannot find user", HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
