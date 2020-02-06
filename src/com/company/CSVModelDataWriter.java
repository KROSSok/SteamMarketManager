package com.company;

import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;

public class CSVModelDataWriter {
    static void writeDataFromURLToCSV(MarketItem item, String csv) throws Exception {
        String [] urlData = {
                item.getSuccess().toString(),
                (new DecimalFormat("##,###.##\u20ac").format(item.getLowest_price())),
                Integer.toString(item.getVolume()),
                (new DecimalFormat("##,###.##\u20ac").format(item.getMedian_price())),
                item.getTime()
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
