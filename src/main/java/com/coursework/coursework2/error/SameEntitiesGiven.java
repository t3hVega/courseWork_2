package com.coursework.coursework2.error;

public class SameEntitiesGiven extends RuntimeException{
    public SameEntitiesGiven(String message) {
        super(message);
    }
}
