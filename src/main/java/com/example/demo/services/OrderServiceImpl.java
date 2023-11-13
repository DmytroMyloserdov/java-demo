package com.example.demo.services;

import com.example.demo.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private DateTransformer dateTransformer;

    private final List<Order> orders = new ArrayList<>();
    private Long nextOrderId = 1L;

    @Override
    public List<Order> getAllOrders() {

        return orders;
    }

    @Override
    public Order getOrderById(Long id) {

        return orders.stream()
                .filter(order -> order.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Order createOrder(Order order) {

        order.setId(nextOrderId++);
        order.setCreateDate(dateTransformer.transform(order.getCreateDate()));
        orders.add(order);
        return order;
    }

    @Override
    public Order updateOrder(Long id, Order updatedOrder) {
        for (Order order : orders) {
            if (order.getId().equals(id)) {

                order.setPrice(updatedOrder.getPrice());
                order.setCustomerName(updatedOrder.getCustomerName());
                return order;
            }
        }
        return null;
    }

    @Override
    public void deleteOrder(Long id) {

        orders.removeIf(order -> order.getId().equals(id));
    }
}
