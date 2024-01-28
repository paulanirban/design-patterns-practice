package com.practice.designpatterns.creational.prototype.objectcloning.impl;

import com.practice.designpatterns.creational.prototype.objectcloning.User;
import com.practice.designpatterns.creational.prototype.objectcloning.UserType;
import com.practice.designpatterns.creational.prototype.objectcloning.interfaces.UserPrototypeRegistry;

import java.util.HashMap;

public class UserPrototypeRegistryImpl implements UserPrototypeRegistry {
    HashMap<UserType, User> map = new HashMap<>();

    @Override
    public void addPrototype(User user) {
        if(user != null) {
            map.put(user.getType(), user);
        }
    }

    @Override
    public User getPrototype(UserType type) {
        if(type != null) {
            return map.get(type);
        }
        return null;
    }

    @Override
    public User clone(UserType type) {
        if(type != null) {
            return map.get(type).cloneObject();
        }
        return null;
    }
}
