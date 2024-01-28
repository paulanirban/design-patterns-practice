package com.practice.designpatterns.creational.factory.abstractfactory.documentprocessing;

import com.practice.designpatterns.creational.factory.abstractfactory.documentprocessing.parser.DocumentParser;
import com.practice.designpatterns.creational.factory.abstractfactory.documentprocessing.printer.DocumentPrinter;
import com.practice.designpatterns.creational.factory.abstractfactory.documentprocessing.processor.DocumentProcessor;

public abstract class DocumentFactory {
    public abstract DocumentType supportsType();
    public abstract DocumentProcessor createDocumentProcessor(String documentName);
    public abstract DocumentParser createDocumentParser(String path);
    public abstract DocumentPrinter createDocumentPrinter(DocumentProcessor processor);
}
