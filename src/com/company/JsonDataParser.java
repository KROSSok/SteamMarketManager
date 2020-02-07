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
        Double lowest_price;
        Double median_price;
        String currency = "\u20ac";
        try {
            lowest_price = (new DecimalFormat("##,###.###"+currency)).parse((String) jParser.get("lowest_price")).doubleValue();
        }
        catch(Exception e) {
            String split[] = ((String) jParser.get("lowest_price")).split(",");
            lowest_price = Double.parseDouble(split[0]);
        }

        try {
            median_price = ((new DecimalFormat("##,###.###"+currency)).parse((String) jParser.get("median_price"))).doubleValue();
        }
        catch(Exception e) {
            String split[] = ((String) jParser.get("median_price")).split(",");
            median_price = Double.parseDouble(split[0]);
        }

        MarketItem item = new MarketItem(
                    (Boolean) jParser.get("success"),
                    lowest_price,
                    Integer.parseInt((String) jParser.get("volume")),
                    median_price,
                    currency
            );
        return item;
    }
}