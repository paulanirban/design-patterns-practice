package com.practice.designpatterns.creational.factory.abstractfactory.documentprocessing.parser;

import com.practice.designpatterns.creational.factory.abstractfactory.documentprocessing.DocumentType;

public class TextDocumentParser extends DocumentParser {

    public TextDocumentParser(String path) {
        super(path);
    }

    public void parseDocument() {
        // Parse text document
    }

    @Override
    public DocumentType supportsType() {
        return DocumentType.TEXT;
    }
}
