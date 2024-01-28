package com.practice.designpatterns.creational.factory.abstractfactory.documentprocessing.parser;

import com.practice.designpatterns.creational.factory.abstractfactory.documentprocessing.DocumentType;

public abstract class DocumentParser {
    private final String path;

    public DocumentParser(String path) {
        this.path = path;
    }

    public abstract void parseDocument();

    public String getPath() {
        return path;
    }

    public abstract DocumentType supportsType();

}
