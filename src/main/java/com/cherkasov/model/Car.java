package com.cherkasov.model;

import java.util.Random;
import java.util.UUID;

public class Car {
    private final String id;
    private String manufacturer;
    private Engine engine;
    private Color color;
    private int count;
    private int price;

    public Car(String manufacturer, Engine engine, Color color) {
        this.manufacturer = manufacturer;
        this.color = color;
        this.engine = engine;
        count = 1;
        price = new Random().nextInt(10000, 100000);
        id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setColor(final Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(final Engine engine) {
        this.engine = engine;
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

    @Override
    public String toString() {
        return String.format("ID: %s, Manufacturer: %s, Engine: %s, %s, Color: %s, Count; %s, Price; %s%n",
                id, manufacturer, engine.getType(), engine.getPower(), color, count, price);
    }
}