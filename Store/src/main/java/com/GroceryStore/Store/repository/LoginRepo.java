package com.GroceryStore.Store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.GroceryStore.Store.model.Login;
@Repository
public interface LoginRepo extends JpaRepository<Login, Integer> {
}