package com.cherkasov.model;

import lombok.Data;

import java.util.Random;
import java.util.UUID;

@Data
public class Car {
    private final String id;
    private String manufacturer;
    private Engine engine;
    private Color color;
    private int count;
    private int price;

    public Car() {
        this.id = UUID.randomUUID().toString();
    }

    public Car(String manufacturer, Engine engine, Color color) {
        this.manufacturer = manufacturer;
        this.color = color;
        this.engine = engine;
        count = 1;
        price = new Random().nextInt(10000, 100000);
        id = UUID.randomUUID().toString();
    }
}