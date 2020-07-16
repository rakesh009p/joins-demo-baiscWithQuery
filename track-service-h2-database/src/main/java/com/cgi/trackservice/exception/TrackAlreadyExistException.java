package com.cgi.trackservice.exception;

//track already exist exception
public class TrackAlreadyExistException extends Exception {
    private String message;

    public TrackAlreadyExistException(String message) {
        super(message);
        System.out.println(message);
        this.message = message;
    }

    //empty constructor
    public TrackAlreadyExistException() {
    }
}