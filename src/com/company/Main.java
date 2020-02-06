package com.company;

public class Main {

    public static void main(String[] args) throws Exception{

        String url;
        JsonDataParser jsonDataParser = new JsonDataParser("steamUrl.json");
        url = jsonDataParser.getStringObject("url");
        System.out.println(url);

        URLDataWriter urlDataWriter = new URLDataWriter();
        String data = urlDataWriter.getDataFromURL(url);
        System.out.println(data);

        MarketItem item;
        item = jsonDataParser.getDataByKey(data);
        System.out.println(item.toString());

        CSVModelDataWriter csvModelDataWriter = new CSVModelDataWriter();
        csvModelDataWriter.writeDataFromURLToCSV(item, "steamData.csv");

        ThreadRunner run = new ThreadRunner();
        run.run();

    }
}
