package com.vm.spring.transaction.poc.service;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.vm.spring.transaction.poc.exception.InvalidOrderItemException;
import com.vm.spring.transaction.poc.model.OrderItem;

//@Transactional
public interface OrderService {

    void persistOrders(List<OrderItem> orderItems) throws InvalidOrderItemException;

    List<OrderItem> getAllOrders();
}