package com.practice.designpatterns.creational.singleton.sample;

public class SingleObjectClass {
    private String str;
    private static SingleObjectClass instance;

    private SingleObjectClass() {
    }

    public static SingleObjectClass getInstance() {
        if(instance == null) {
            instance = new SingleObjectClass();
        }

        return instance;
    }
}
