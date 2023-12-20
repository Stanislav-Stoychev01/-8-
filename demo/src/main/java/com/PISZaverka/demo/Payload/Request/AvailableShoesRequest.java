package com.PISZaverka.demo.Payload.Request;

import java.util.List;

public class AvailableShoesRequest {

    private String brand;
    private String model;
    private String color;
    private Double price;
    private List<Integer> sizes;

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public Double getPrice() {
        return price;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setSizes(List<Integer> sizes) {
        this.sizes = sizes;
    }

    public List<Integer> getSizes() {
        return sizes;
    }

}
