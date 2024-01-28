package com.practice.designpatterns.creational.factory.simplefactory.documentprocessing;

public abstract class DocumentProcessor {
    private String documentName;
    public abstract String getDocumentName();
    public abstract DocumentType supportsType();
    public abstract void processDocument();
}
