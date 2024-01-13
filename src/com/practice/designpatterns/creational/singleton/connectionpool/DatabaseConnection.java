package com.practice.designpatterns.creational.singleton.connectionpool;

public class DatabaseConnection {
    private boolean isAvailable = true;

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
