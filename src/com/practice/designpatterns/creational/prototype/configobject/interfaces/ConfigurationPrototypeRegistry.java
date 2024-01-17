package com.practice.designpatterns.creational.prototype.configobject.interfaces;

import com.practice.designpatterns.creational.prototype.configobject.Configuration;
import com.practice.designpatterns.creational.prototype.configobject.ConfigurationType;

public interface ConfigurationPrototypeRegistry {
    void addPrototype(Configuration user);

    Configuration getPrototype(ConfigurationType type);

    Configuration clone(ConfigurationType type);
}
