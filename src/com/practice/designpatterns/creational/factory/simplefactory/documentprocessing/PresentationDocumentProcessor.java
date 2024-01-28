package com.practice.designpatterns.creational.factory.simplefactory.documentprocessing;

public class PresentationDocumentProcessor extends DocumentProcessor {
    private final String documentName;

    public PresentationDocumentProcessor(String documentName) {
        this.documentName = documentName;
    }
    @Override
    public String getDocumentName() {
        return documentName;
    }

    @Override
    public DocumentType supportsType() {
        return DocumentType.PRESENTATION;
    }

    @Override
    public void processDocument() {
        // Implement presentation document processing logic
        System.out.println("Processing a presentation document: " + getDocumentName());
        // Additional logic for presentation document processing
    }

    public void addSlide() {
        System.out.println("Adding a slide to the presentation.");
    }
}
