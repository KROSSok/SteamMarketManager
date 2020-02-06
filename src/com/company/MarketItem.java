package com.company;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class MarketItem {

    private Boolean success;
    private Double lowest_price;
    private int volume;
    private Double median_price;
    private String time;

    public Boolean getSuccess() {
        return success;
    }

    public Double getLowest_price() {
        return lowest_price;
    }

    public int getVolume() {
        return volume;
    }

    public Double getMedian_price() {
        return median_price;
    }

    public String getTime(){
        return time;
    }

    public MarketItem(Boolean success, Double lowest_price, int volume, Double median_price){
        this.success = success;
        this.lowest_price = lowest_price;
        this.median_price = median_price;
        this.volume = volume;
        this.time = (new SimpleDateFormat("yyyy/MM/dd '-' HH:mm:ss.sss z")).format(System.currentTimeMillis());
    }

    @Override
    public String toString() {
        return "MarketItem " +
                "success=" + success +
                ", lowest_price='" + (new DecimalFormat("##,###.###\u20ac").format(lowest_price)) + '\'' +
                ", volume='" + volume + '\'' +
                ", median_price='" + (new DecimalFormat("##,###.###\u20ac").format(median_price)) + '\'' +
                ", time='" + time + '\'' +
                ' ';
    }
}
