package com.company;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.text.DecimalFormat;

public class JsonDataParser {

    private final JSONObject mFileJson;

    public JsonDataParser(String fileName) throws Exception{
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

    static MarketItem getDataByKey(String data)throws Exception{
        JSONParser jsonParser = new JSONParser();
        Object object = jsonParser.parse(data);
        JSONObject jParser = (JSONObject) object;

        MarketItem item = new MarketItem(
                    (Boolean) jParser.get("success"),
                    (new DecimalFormat("##,###.###\u20ac")).parse((String) jParser.get("lowest_price")).doubleValue(),
                    Integer.parseInt((String) jParser.get("volume")),
                    ((new DecimalFormat("##,###.###'--'\u20ac")).parse((String) jParser.get("median_price"))).doubleValue()
            );
        return item;
    }
}
// ((new DecimalFormat("##,###.###\u20ac")).parse((String) jParser.get("lowest_price"))).doubleValue()