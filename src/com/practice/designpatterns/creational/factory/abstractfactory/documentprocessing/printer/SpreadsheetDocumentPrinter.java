package com.practice.designpatterns.creational.factory.abstractfactory.documentprocessing.printer;

import com.practice.designpatterns.creational.factory.abstractfactory.documentprocessing.DocumentType;
import com.practice.designpatterns.creational.factory.abstractfactory.documentprocessing.processor.DocumentProcessor;

public class SpreadsheetDocumentPrinter extends DocumentPrinter {
    public SpreadsheetDocumentPrinter(DocumentProcessor processor) {
        super(processor);
    }
    @Override
    public void printDocument() {
        // Print spreadsheet document
    }

    @Override
    public DocumentType supportsType() {
        return DocumentType.SPREAD_SHEET;
    }
}
