package com.CoreJava.DesignPatterns.Factory.processors;


import com.CoreJava.DesignPatterns.Factory.Pasers.ParserFactory;
import com.CoreJava.DesignPatterns.Factory.domain.Records;

import java.io.File;
import java.util.List;

public abstract class BatchProcessor {

    public final void processBatch(String fileName) {
        File file = openFile(fileName);
        ParserFactory.Parser parser = createParser(file);
        List<Records> records = parser.parse();
        processRecords(records);
        writeSummary();
        closeFile(file);
    }

    abstract ParserFactory.Parser createParser(File file);

    private File openFile(String fileName) {
        System.out.println("Open File");
        return  new File(fileName);
    }

    private void processRecords(List<Records> records) {
        System.out.println("processing Records");
    }

    private void writeSummary() {
        System.out.println("Wrote batch summary");
    }

    private void closeFile(File file) {
        System.out.println("Closed File");
    }


}
