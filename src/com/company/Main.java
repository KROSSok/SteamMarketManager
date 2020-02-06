package com.company;

public class Main {

    public static void main(String[] args) throws Exception{
	// write your code here
        String url;
        JsonURLParser jsonURLParser = new JsonURLParser("steamUrl.json");
        url = jsonURLParser.getStringObject("url");
        System.out.println(url);

        URLDataWriter urlDataWriter = new URLDataWriter();
        String data = urlDataWriter.getDataFromURL(url);
        System.out.println(data);

        MarketItem item;
        JsonModelDataParser jsonModelDataParser = new JsonModelDataParser();
        item = jsonModelDataParser.getDataByKey(data);
        System.out.println(item.toString());

        CSVModelDataWriter csvModelDataWriter = new CSVModelDataWriter();
        csvModelDataWriter.writeDataFromURLToCSV(item, "steamData.csv");

        ThreadRunner run = new ThreadRunner();
        run.run();

    }
}
