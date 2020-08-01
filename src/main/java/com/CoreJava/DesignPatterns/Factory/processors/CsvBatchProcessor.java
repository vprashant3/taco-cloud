package com.CoreJava.DesignPatterns.Factory.processors;

import com.CoreJava.DesignPatterns.Factory.Pasers.CsvParser;
import com.CoreJava.DesignPatterns.Factory.Pasers.ParserFactory;

import java.io.File;

public class CsvBatchProcessor extends BatchProcessor {
    @Override
    ParserFactory.Parser createParser(File file) {
        return new CsvParser(file);
    }
}
