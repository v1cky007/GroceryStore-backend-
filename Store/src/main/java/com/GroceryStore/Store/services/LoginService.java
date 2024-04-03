package com.GroceryStore.Store.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GroceryStore.Store.model.Login;
import com.GroceryStore.Store.repository.LoginRepo;

@Service
public class LoginService {
    @Autowired
    private LoginRepo repo;

    public Login createLogin(Login login) {
        return repo.save(login);
    }

    public List<Login> getAllLogins() {
        return repo.findAll();
    }

    public Optional<Login> getLoginById(Integer loginId) {
        return repo.findById(loginId);
    }

    public Login updateLogin(Login login) {
        return repo.save(login);
    }

    public void deleteLogin(Integer loginId) {
        repo.deleteById(loginId);
    }
}
