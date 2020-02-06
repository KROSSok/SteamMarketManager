package com.company;

public class MarketItem {

    private Boolean success;
    private String lowest_price;
    private String volume;
    private String median_price;

    public Boolean getSuccess() {
        return success;
    }

    public String getLowest_price() {
        return lowest_price;
    }

    public String getVolume() {
        return volume;
    }

    public String getMedian_price() {
        return median_price;
    }

    public MarketItem(Boolean success, String lowest_price, String volume, String median_price){
        this.success = success;
        this.lowest_price = lowest_price;
        this.volume = volume;
        this.median_price = median_price;
    }


    @Override
    public String toString() {
        return "MarketItem " +
                "success=" + success +
                ", lowest_price='" + lowest_price + '\'' +
                ", volume='" + volume + '\'' +
                ", median_price='" + median_price + '\'' +
                ' ';
    }
}
