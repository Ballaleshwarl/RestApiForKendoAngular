package com.springRest.demo1.response;

public class LoginMessage {

    private  String message;

    private boolean value;

    public LoginMessage() {
    }

    public LoginMessage(String message, boolean value) {
        this.message = message;
        this.value = value;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }
}
