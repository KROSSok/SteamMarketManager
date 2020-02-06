package com.company;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonModelDataParser {
    static MarketItem getDataByKey(String data)throws Exception{
        JSONParser jsonParser = new JSONParser();
        Object object = jsonParser.parse(data);
        JSONObject jParser = (JSONObject) object;
        MarketItem item = new MarketItem(
                (Boolean) jParser.get("success"),
                (String) jParser.get("lowest_price"),
                (String) jParser.get("volume"),
                (String) jParser.get("median_price")
        );
        return item;
    }
}
