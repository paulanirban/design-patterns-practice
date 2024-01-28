package com.practice.designpatterns.creational.factory.abstractfactory.documentprocessing.printer;

import com.practice.designpatterns.creational.factory.abstractfactory.documentprocessing.DocumentType;
import com.practice.designpatterns.creational.factory.abstractfactory.documentprocessing.processor.DocumentProcessor;

public abstract class DocumentPrinter {

    private final DocumentProcessor processor;

    public DocumentPrinter(DocumentProcessor processor) {
        this.processor = processor;
    }

    public DocumentProcessor getProcessor() {
        return processor;
    }

    public abstract void printDocument();

    public abstract DocumentType supportsType();

}
