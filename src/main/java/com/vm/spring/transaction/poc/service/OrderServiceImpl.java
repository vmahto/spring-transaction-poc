package com.vm.spring.transaction.poc.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vm.spring.transaction.poc.dao.Dao;
import com.vm.spring.transaction.poc.exception.InvalidOrderItemException;
import com.vm.spring.transaction.poc.model.OrderItem;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private Dao<OrderItem> dao;

    @Override
    @Transactional(rollbackFor = InvalidOrderItemException.class)
    public void persistOrders(List<OrderItem> orderItems) throws InvalidOrderItemException {
        for (OrderItem orderItem : orderItems) {
            if (orderItem.getQty() > 100) {
                throw new InvalidOrderItemException(
                        "Order quantity cannot be more than 100, found: "
                                + orderItem.getQty());
            }
            long id = dao.save(orderItem);
            System.out.println("id generated: " + id);
        }
    }

    @Override
    public List<OrderItem> getAllOrders() {
        return dao.loadAll();
    }
}