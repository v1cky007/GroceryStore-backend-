// OrderItemRepository.java
package com.GroceryStore.Store.repository;

import com.GroceryStore.Store.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
    List<OrderItem> findByLoginId(int loginId);
}
