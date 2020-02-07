package com.company;

import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;


public class CSVModelDataWriter {
    static void writeDataFromURLToCSV(MarketItem item, String csv) throws Exception {
        String [] urlData = {
                item.getSuccess().toString(),
                " " + item.getLowest_price()+item.getCurrency(),
                " " + item.getVolume(),
                " " + item.getMedian_price()+item.getCurrency(),
                " " + item.getTime()
        };
        String [] header = {"success", "lowest_price", "volume", "media_price", "time"};
        if(Files.exists(Paths.get("steamData.csv"))){
            CSVWriter writer = new CSVWriter(new FileWriter(csv, true));
            writer.writeNext(urlData, false);
            writer.close();
        }
        else {
            CSVWriter writer = new CSVWriter(new FileWriter(csv));
            writer.writeNext(header, false);
            writer.writeNext(urlData, false);
            writer.close();
        }
    }
}
