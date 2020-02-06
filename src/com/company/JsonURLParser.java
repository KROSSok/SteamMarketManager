package com.company;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;


public class JsonURLParser {

    private final JSONObject mFileJson;

    public JsonURLParser(String fileName) throws Exception{
        JSONParser jsonParser = new JSONParser();
        Object object = jsonParser.parse(new FileReader(fileName));
        JSONObject jsonFileParser = (JSONObject) object;
        this.mFileJson = jsonFileParser;
    }

    String getStringObject(String key) {
        String url;
        url = (String) mFileJson.get(key);
        return url;
    }
}
