package com.practice.designpatterns.creational.singleton.configmanager.impl;

import com.practice.designpatterns.creational.singleton.configmanager.FileBasedConfigurationManager;

public class FileBasedConfigurationManagerImpl extends FileBasedConfigurationManager {

    private static volatile FileBasedConfigurationManager instance;

    private FileBasedConfigurationManagerImpl() {
        super();
    }

    @Override
    public String getConfiguration(String key) {
        if(key != null) {
            return properties.getProperty(key);
        }
        return null;
    }

    @Override
    public <T> T getConfiguration(String key, Class<T> type) {
        String value = getConfiguration(key);
        if(value != null) {
            return convert(getConfiguration(key), type);
        }
        return null;
    }

    @Override
    public void setConfiguration(String key, String value) {
        if(key != null) {
            properties.setProperty(key, value);
        }
    }

    @Override
    public <T> void setConfiguration(String key, T value) {
        if(value != null) {
            setConfiguration(key, value.toString());
        }
    }

    @Override
    public void removeConfiguration(String key) {
        if(key != null) {
            properties.remove(key);
        }
    }

    @Override
    public void clear() {
        properties.clear();
    }

    public static FileBasedConfigurationManager getInstance() {
        if(instance == null) {
            synchronized (FileBasedConfigurationManagerImpl.class) {
                if (instance == null) {
                    instance = new FileBasedConfigurationManagerImpl();
                }
            }
        }

        return instance;
    }

    public static void resetInstance() {
        if (instance != null) {
            instance = null;
        }
    }
}
