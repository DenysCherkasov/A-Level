package com.cherkasov.model;

import lombok.*;

import java.util.Objects;
import java.util.Random;
import java.util.UUID;

@Setter
@Getter
public abstract class Car implements CountRestore {
    protected Type type;
    protected final String id;
    protected String manufacturer;
    protected Engine engine;
    protected Color color;
    protected int count;
    protected int price;
    private Random random = new Random();
    public Car() {
        this.id = UUID.randomUUID().toString();
    }

    public Car(String manufacturer, Engine engine, Color color, Type type) {
        this.manufacturer = manufacturer;
        this.color = color;
        this.engine = engine;
        this.type = type;
        count = random.nextInt(100);
        price = random.nextInt(10000, 100000);
        id = UUID.randomUUID().toString();
    }

    @Override
    public String toString() {
        return String.format("ID: %s, Type: %s, " +
                        "Manufacturer: %s, Engine: %s, " +
                        "Color: %s, Count; %s, Price; %s",
                id, type, manufacturer, engine, color, count, price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id.equals(car.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}