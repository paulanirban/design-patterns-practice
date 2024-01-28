package com.practice.designpatterns.creational.factory.abstractfactory.documentprocessing.parser;

import com.practice.designpatterns.creational.factory.abstractfactory.documentprocessing.DocumentType;

public class SpreadsheetDocumentParser extends DocumentParser {

    public SpreadsheetDocumentParser(String path) {
        super(path);
    }

    public void parseDocument() {
        // Parse spreadsheet document
    }

    @Override
    public DocumentType supportsType() {
        return DocumentType.SPREAD_SHEET;
    }
}
