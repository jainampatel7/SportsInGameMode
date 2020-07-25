package com.example.sportsin.FoodActivity;

public class FoodCartDataModel {
    private String merch_name;
    private String merch_size;
    private String merch_price;
    private String merch_image;

    public FoodCartDataModel(String merch_name, String merch_size, String merch_price, String merch_image) {
        this.merch_name = merch_name;
        this.merch_size = merch_size;
        this.merch_price = merch_price;
        this.merch_image = merch_image;
    }

    public FoodCartDataModel() {

    }

    public String getMerch_name() {
        return merch_name;
    }

    public void setMerch_name(String merch_name) {
        this.merch_name = merch_name;
    }

    public String getMerch_size() {
        return merch_size;
    }

    public void setMerch_size(String merch_size) {
        this.merch_size = merch_size;
    }

    public String getMerch_price() {
        return merch_price;
    }

    public void setMerch_price(String merch_price) {
        this.merch_price = merch_price;
    }

    public String getMerch_image() {
        return merch_image;
    }

    public void setMerch_image(String merch_image) {
        this.merch_image = merch_image;
    }
}
