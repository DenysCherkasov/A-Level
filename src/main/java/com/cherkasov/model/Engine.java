package com.cherkasov.model;

import lombok.Data;

import java.util.Random;

@Data
public class Engine {
    private int power;
    private String type;

    public Engine(String type) {
        power = new Random().nextInt(1000);
        this.type = type;
    }
}