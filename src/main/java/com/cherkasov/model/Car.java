package com.cherkasov.model;

import java.util.Random;

public class Car {
    private String manufacturer;
    private String engine;
    private String color;
    private int count;
    private int price;

    public Car() {
    }

    public Car(String manufacturer, String engine, String color) {
        this.manufacturer = manufacturer;
        this.engine = engine;
        this.color = color;
        count = 1;
        price = new Random().nextInt(10000, 100000);
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setEngine(final String engine) {
        this.engine = engine;
    }

    public String getEngine() {
        return engine;
    }

    public void setColor(final String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setCount(final int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setPrice(final int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}