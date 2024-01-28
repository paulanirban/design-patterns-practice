package com.practice.designpatterns.creational.factory.simplefactory.documentprocessing;

public class SpreadsheetDocumentProcessor extends DocumentProcessor {
    private String documentName;

    public SpreadsheetDocumentProcessor(String documentName) {
        this.documentName = documentName;
    }

    @Override
    public String getDocumentName() {
        return documentName;
    }

    @Override
    public DocumentType supportsType() {
        return DocumentType.SPREAD_SHEET;
    }

    @Override
    public void processDocument() {
        // Implement spreadsheet document processing logic
        System.out.println("Processing a spreadsheet document: " + getDocumentName());
        // Additional logic for spreadsheet document processing
    }

    public void performDataAnalysis() {
        System.out.println("Performing data analysis on the spreadsheet.");
    }
}
