package com.practice.designpatterns.creational.prototype.objectcloning.interfaces;

import com.practice.designpatterns.creational.prototype.objectcloning.User;
import com.practice.designpatterns.creational.prototype.objectcloning.UserType;

public interface UserPrototypeRegistry {
    void addPrototype(User user);

    User getPrototype(UserType type);

    User clone(UserType type);
}
