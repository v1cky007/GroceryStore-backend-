// OrderItemService.java
package com.GroceryStore.Store.services;

import com.GroceryStore.Store.model.OrderItem;
import com.GroceryStore.Store.repository.OrderItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService {
    private final OrderItemRepository orderItemRepository;

    public OrderItemService(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    public OrderItem createOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    public List<OrderItem> getOrderItemsByLoginId(int loginId) {
        return orderItemRepository.findByLoginId(loginId);
    }
}
