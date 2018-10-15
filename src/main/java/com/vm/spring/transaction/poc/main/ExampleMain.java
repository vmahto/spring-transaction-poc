package com.vm.spring.transaction.poc.main;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.vm.spring.transaction.poc.client.OrderItemClientBean;
import com.vm.spring.transaction.poc.config.AppConfig;

public class ExampleMain {
    public static void main(String[] args) {
    	
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        
        OrderItemClientBean orderItemClientBean = context.getBean(OrderItemClientBean.class);
        orderItemClientBean.persistOrderItems();
        
    }
}