package com.CoreJava.DesignPatterns.Factory.Pasers;

import com.CoreJava.DesignPatterns.Factory.domain.Records;

import java.io.File;
import java.util.List;

public class CsvParser implements ParserFactory.Parser {

    public CsvParser(File file) {
        System.out.println("Creating Csv parser");
    }

    public List<Records> parse() {
        System.out.println("Parsing Csv and creating record list");
        return  null;
    }
}
