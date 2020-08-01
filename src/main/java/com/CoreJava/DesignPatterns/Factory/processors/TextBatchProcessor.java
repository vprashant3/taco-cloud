package com.CoreJava.DesignPatterns.Factory.processors;

import com.CoreJava.DesignPatterns.Factory.Pasers.ParserFactory;

import java.io.File;

public class TextBatchProcessor extends BatchProcessor {
    @Override
    ParserFactory.Parser createParser(File file) {
        return new ParserFactory.TextParser(file);
    }
}
