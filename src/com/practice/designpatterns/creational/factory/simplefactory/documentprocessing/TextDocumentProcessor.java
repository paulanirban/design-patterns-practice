package com.practice.designpatterns.creational.factory.simplefactory.documentprocessing;

public class TextDocumentProcessor extends DocumentProcessor {
    private final String documentName;

    public TextDocumentProcessor(String documentName) {
        this.documentName = documentName;
    }

    @Override
    public String getDocumentName() {
        return documentName;
    }

    @Override
    public DocumentType supportsType() {
        return DocumentType.TEXT;
    }

    @Override
    public void processDocument() {
        // Implement text document processing logic
        System.out.println("Processing a text document: " + getDocumentName());
        // Additional logic for text document processing
    }
}
