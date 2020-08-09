package com.CoreJava.json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

public class JsonParser {

    public static void main(String[] args) throws ParseException, IOException {
        JSONParser parser = new JSONParser();

        Object parse = parser.parse(new FileReader("/Users/prverma/Development/LearnEveryDay/src/main/resources/Json/InputJson.txt"));

        JSONArray jsonObject = (JSONArray) parse;

        Iterator iterator = jsonObject.iterator();

        while(iterator.hasNext()) {
            JSONObject next = (JSONObject) iterator.next();
            System.out.println(next.get("name"));
            long curId = (long) next.get("id");
            next.replace("id", curId+1);
        }

        FileWriter file = new FileWriter("/Users/prverma/Development/LearnEveryDay/src/main/resources/Json/OutputJson.txt");

        file.write(jsonObject.toJSONString());

        file.close();

    }

}
