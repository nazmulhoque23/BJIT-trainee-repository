package com.bjit.main.controller;

import com.bjit.main.exception.AdminNotFoundException;
import com.bjit.main.model.Admin;
import com.bjit.main.model.Candidate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidate")
public class CandidateController {
    @GetMapping("/get-info/{id}")
    public ResponseEntity<Object> getCandidateInfo(@PathVariable Integer id) {
        if(id == 1001) {
            Candidate candidate = new Candidate(1001, "Candidate 1");
            return new ResponseEntity<>(candidate, HttpStatus.OK);
        } else {
            throw new AdminNotFoundException("Candidate not found");
        }
    }

    @GetMapping("/some-method")
    public ResponseEntity<Object> someMethod() {
        throw new ArithmeticException("Error");
    }
}
