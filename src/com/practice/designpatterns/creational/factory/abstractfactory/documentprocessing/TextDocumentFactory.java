package com.practice.designpatterns.creational.factory.abstractfactory.documentprocessing;

import com.practice.designpatterns.creational.factory.abstractfactory.documentprocessing.parser.DocumentParser;
import com.practice.designpatterns.creational.factory.abstractfactory.documentprocessing.parser.TextDocumentParser;
import com.practice.designpatterns.creational.factory.abstractfactory.documentprocessing.printer.DocumentPrinter;
import com.practice.designpatterns.creational.factory.abstractfactory.documentprocessing.printer.TextDocumentPrinter;
import com.practice.designpatterns.creational.factory.abstractfactory.documentprocessing.processor.DocumentProcessor;
import com.practice.designpatterns.creational.factory.abstractfactory.documentprocessing.processor.TextDocumentProcessor;

public class TextDocumentFactory extends DocumentFactory {
    @Override
    public DocumentType supportsType() {
        return DocumentType.TEXT;
    }

    @Override
    public DocumentProcessor createDocumentProcessor(String documentName) {
        return new TextDocumentProcessor(documentName);
    }

    @Override
    public DocumentParser createDocumentParser(String path) {
        return new TextDocumentParser(path);
    }

    @Override
    public DocumentPrinter createDocumentPrinter(DocumentProcessor processor) {
        return new TextDocumentPrinter(processor);
    }
}
