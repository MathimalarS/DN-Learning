package com.example.factory;

public class FactoryMethodTest {

    public static void main(String[] args) {
        DocumentFactory factory;
        Document document;

        factory = new WordDocumentFactory();
        document = factory.createDocument();
        document.open();
        document.save();
        document.close();

        System.out.println();

        factory = new PdfDocumentFactory();
        document = factory.createDocument();
        document.open();
        document.save();
        document.close();

        System.out.println();

        factory = new ExcelDocumentFactory();
        document = factory.createDocument();
        document.open();
        document.save();
        document.close();
    }
}
