package com.cherkasov.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Truck extends Car implements CountRestore {
    private int loadCopacity;

    public Truck(String manufacturer, Engine engine, Color color, int loadCopacity) {
        super(manufacturer, engine, color);
        this.loadCopacity = loadCopacity;
    }

    @Override
    public void restore() {
        setCount(50);
        System.out.println(getCount());    }
}
