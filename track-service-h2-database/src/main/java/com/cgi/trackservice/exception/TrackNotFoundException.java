package com.cgi.trackservice.exception;

//track  not found exception
public class TrackNotFoundException extends Exception {
    private String message;

    public TrackNotFoundException(String message) {
        super(message);
        this.message = message;
    }

    //empty constructor
    public TrackNotFoundException() {
    }
}