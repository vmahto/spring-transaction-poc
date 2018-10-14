package com.vm.spring.transaction.poc.exception;

public class InvalidOrderItemException extends Exception {
   
	public InvalidOrderItemException(String message) {
        super(message);
    }
}