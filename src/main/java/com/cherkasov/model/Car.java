package com.cherkasov.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Random;
import java.util.UUID;

@Data
@Setter
@Getter
public abstract class Car {
    private Type type;
    private final String id;
    private String manufacturer;
    private Engine engine;
    private Color color;
    private int count;
    private int price;

    public Car() {
        this.id = UUID.randomUUID().toString();
    }

    public Car(String manufacturer, Engine engine, Color color, Type type) {
        this.manufacturer = manufacturer;
        this.color = color;
        this.engine = engine;
        this.type = type;
        count = 1;
        price = new Random().nextInt(10000, 100000);
        id = UUID.randomUUID().toString();
    }
    @Override
    public String toString() {
        return String.format("ID: %s, Type: %s, Manufacturer: %s, Engine: %s, Color: %s, Count; %s, Price; %s",
                id, type, manufacturer, engine, color, count, price);
    }

}