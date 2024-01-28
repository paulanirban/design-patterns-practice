package com.practice.designpatterns.creational.factory.simplefactory.documentprocessing;

public class DocumentProcessorFactory {
    public static DocumentProcessor getDocumentProcessor(DocumentType docType, String documentName) {
        switch (docType) {
            case TEXT:
                return new TextDocumentProcessor(documentName);
            case PRESENTATION:
                return new PresentationDocumentProcessor(documentName);
            case SPREAD_SHEET:
                return new SpreadsheetDocumentProcessor(documentName);
        }

        return null;
    }
}
