package com.practice.designpatterns.creational.prototype.sample;

import java.util.HashMap;
import java.util.Map;

public class Registry<E> {
    private Map<String, E> map = new HashMap<>();

    void register(String key, E value) {
        map.put(key, value);
    }

    E get(String key) {
        return map.get(key);
    }
}
