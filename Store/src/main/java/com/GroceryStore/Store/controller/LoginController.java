package com.GroceryStore.Store.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.GroceryStore.Store.model.Login;
import com.GroceryStore.Store.services.LoginService;

@RestController
@RequestMapping("/api")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<Login> createUser(@RequestBody Login login) {
        Login createdLogin = loginService.createLogin(login);
        if (createdLogin != null) {
            return new ResponseEntity<>(createdLogin, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/login")
    public ResponseEntity<List<Login>> getAllLogins() {
        List<Login> logins = loginService.getAllLogins();
        if (!logins.isEmpty()) {
            return new ResponseEntity<>(logins, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/login/{loginId}")
    public ResponseEntity<Login> getLoginById(@PathVariable int loginId) {
        Optional<Login> login = loginService.getLoginById(loginId);
        if (login.isPresent()) {
            return new ResponseEntity<>(login.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/login/{loginId}")
    public ResponseEntity<Login> updateLogin(@PathVariable int loginId, @RequestBody Login login) {
        Optional<Login> existingLogin = loginService.getLoginById(loginId);
        if (existingLogin.isPresent()) {
            login.setId(loginId); // Set the ID to ensure update occurs on correct entity
            Login updatedLogin = loginService.updateLogin(login);
            return new ResponseEntity<>(updatedLogin, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/login/{loginId}")
    public ResponseEntity<Void> deleteLogin(@PathVariable int loginId) {
        Optional<Login> existingLogin = loginService.getLoginById(loginId);
        if (existingLogin.isPresent()) {
            loginService.deleteLogin(loginId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
