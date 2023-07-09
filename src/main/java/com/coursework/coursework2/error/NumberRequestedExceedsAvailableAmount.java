package com.coursework.coursework2.error;

public class NumberRequestedExceedsAvailableAmount extends RuntimeException{
    public NumberRequestedExceedsAvailableAmount(String message) {
        super(message);
    }
}
