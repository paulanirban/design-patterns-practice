package com.practice.designpatterns.creational.prototype.configobject.impl;

import com.practice.designpatterns.creational.prototype.configobject.Configuration;
import com.practice.designpatterns.creational.prototype.configobject.ConfigurationType;
import com.practice.designpatterns.creational.prototype.configobject.interfaces.ConfigurationPrototypeRegistry;

import java.util.HashMap;

public class ConfigurationPrototypeRegistryImpl implements ConfigurationPrototypeRegistry {
    private HashMap<ConfigurationType, Configuration> map = new HashMap<>();

    @Override
    public void addPrototype(Configuration configuration) {
        map.put(configuration.getType(), configuration);
    }

    @Override
    public Configuration getPrototype(ConfigurationType type) {
        if(type != null) {
            return map.get(type);
        }
        return null;
    }

    @Override
    public Configuration clone(ConfigurationType type) {
        if(type != null) {
            return map.get(type).cloneObject();
        }
        return null;
    }
}
