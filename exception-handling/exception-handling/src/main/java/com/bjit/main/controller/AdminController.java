package com.bjit.main.controller;

import com.bjit.main.exception.AdminNotFoundException;
import com.bjit.main.model.Admin;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/get-info/{id}")
    public ResponseEntity<Object> getAdminInfo(@PathVariable Integer id) {
        if(id == 2001) {
            Admin admin = new Admin("BJIT Admin");
            return new ResponseEntity<>(admin, HttpStatus.OK);
        } else {
            throw new AdminNotFoundException("Admin not found");
        }
    }

    @GetMapping("/some-method")
    public ResponseEntity<Object> someMethod() {
        throw new ArithmeticException("Error");
    }


}
