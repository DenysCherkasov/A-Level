package com.cherkasov.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Data
@Getter
@Setter
public class Engine {
    private int power;
    private String type;

    public Engine(String type) {
        power = new Random().nextInt(1000);
        this.type = type;
    }
    public Engine(String type, int power) {
        this.power = power;
        this.type = type;
    }
    @Override
    public String toString() {
        return String.format("(Power: %s, Type: %s)",
                power, type);
    }

}
