package com.practice.designpatterns.creational.factory.abstractfactory.documentprocessing;

import com.practice.designpatterns.creational.factory.abstractfactory.documentprocessing.parser.DocumentParser;
import com.practice.designpatterns.creational.factory.abstractfactory.documentprocessing.parser.SpreadsheetDocumentParser;
import com.practice.designpatterns.creational.factory.abstractfactory.documentprocessing.printer.DocumentPrinter;
import com.practice.designpatterns.creational.factory.abstractfactory.documentprocessing.printer.SpreadsheetDocumentPrinter;
import com.practice.designpatterns.creational.factory.abstractfactory.documentprocessing.processor.DocumentProcessor;
import com.practice.designpatterns.creational.factory.abstractfactory.documentprocessing.processor.SpreadsheetDocumentProcessor;

public class SpreadsheetDocumentFactory extends DocumentFactory {
    @Override
    public DocumentType supportsType() {
        return DocumentType.SPREAD_SHEET;
    }

    @Override
    public DocumentProcessor createDocumentProcessor(String documentName) {
        return new SpreadsheetDocumentProcessor(documentName);
    }

    @Override
    public DocumentParser createDocumentParser(String path) {
        return new SpreadsheetDocumentParser(path);
    }

    @Override
    public DocumentPrinter createDocumentPrinter(DocumentProcessor processor) {
        return new SpreadsheetDocumentPrinter(processor);
    }
}
