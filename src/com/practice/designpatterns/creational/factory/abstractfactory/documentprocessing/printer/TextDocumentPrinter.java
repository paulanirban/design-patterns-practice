package com.practice.designpatterns.creational.factory.abstractfactory.documentprocessing.printer;

import com.practice.designpatterns.creational.factory.abstractfactory.documentprocessing.DocumentType;
import com.practice.designpatterns.creational.factory.abstractfactory.documentprocessing.processor.DocumentProcessor;

public class TextDocumentPrinter extends DocumentPrinter {
    public TextDocumentPrinter(DocumentProcessor processor) {
        super(processor);
    }
    @Override
    public void printDocument() {
        // Print text document
    }

    @Override
    public DocumentType supportsType() {
        return DocumentType.TEXT;
    }
}
