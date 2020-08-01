package com.CoreJava.DesignPatterns.Factory.Pasers;

import com.CoreJava.DesignPatterns.Factory.domain.Records;

import java.io.File;
import java.util.List;

public class ParserFactory {
    public static Parser createParser(File file, String format) {
        switch (format) {
            case "Text" : return new TextParser(file);
            case "Csv" : return  new CsvParser(file);
        }
        return null;
    }

    public static interface Parser {

        List<Records> parse();
    }

    public static class TextParser implements Parser {

        public TextParser(File file) {
            System.out.println("Creating Text parser");
        }

        public List<Records> parse() {
            System.out.println("Parsing Text and creating record list");
            return  null;
        }
    }
}
