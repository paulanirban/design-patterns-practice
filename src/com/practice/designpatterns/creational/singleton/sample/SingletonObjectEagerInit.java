package com.practice.designpatterns.creational.singleton.sample;

public class SingletonObjectEagerInit {
    private static final SingletonObjectEagerInit instance = new SingletonObjectEagerInit();
    private SingletonObjectEagerInit() {
    }

    public static SingletonObjectEagerInit getInstance() {
        return instance;
    }
}
