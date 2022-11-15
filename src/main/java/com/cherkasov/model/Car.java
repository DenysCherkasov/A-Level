package com.cherkasov.model;

import java.util.Random;
import java.util.UUID;

public class Car {
    private final String id;
    private String manufacturer;
    private String engineType;
    private int enginePower;
    private Color color;
    private int count;
    private int price;

    public Car(String manufacturer, Engine engine, Color color) {
        this.manufacturer = manufacturer;
        this.color = color;
        engineType = engine.getType();
        enginePower = engine.getPower();
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

    public void setEngineType(final Engine engine) {
        this.engineType = engine.getType();
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEnginePower(final Engine engine) {
        this.enginePower = engine.getPower();
    }

    public int getEnginePower() {
        return enginePower;
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
        return String.format("ID: %s, Manufacturer: %s, EnginePower: %s, EngineType: %s, Color: %s, Count; %s, Price; %s%n",
                id, manufacturer, enginePower, engineType, color, count, price);
    }
}