package com.CoreJava.DesignPatterns.Factory;

import com.CoreJava.DesignPatterns.Factory.processors.BatchProcessor;
import com.CoreJava.DesignPatterns.Factory.processors.CsvBatchProcessor;
import com.CoreJava.DesignPatterns.Factory.processors.TextBatchProcessor;

public class App {

    //In the super class you create the factory and subclasses implement the factory
    public static void main(String[] args) {
        BatchProcessor batchProcessor = createBatchProcessor("fileFormat");
        batchProcessor.processBatch("fileName");
        System.out.println("done");
    }

    private static BatchProcessor createBatchProcessor(String fileFormat) {
        switch (fileFormat) {
            case "TEXT" :  return new TextBatchProcessor();
            case "CSV" : return new CsvBatchProcessor();
        }
        return null;
    }
}
