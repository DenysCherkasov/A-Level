package com.cherkasov.model;

import com.cherkasov.service.CarService;

import java.util.Random;

public class Engine {
    private int power;
    private String type;

    public Engine(String type) {
        power = new Random().nextInt(400);
        this.type = type;
    }

    public void setPower(final int power) {
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return String.format("Type: %s, Power: %s",
                type, power);
    }

}