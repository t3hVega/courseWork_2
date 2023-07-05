package com.coursework.coursework2.error;

public class EntityAlreadyPresent extends RuntimeException{
    public EntityAlreadyPresent(String message) {
        super(message);
    }
}
