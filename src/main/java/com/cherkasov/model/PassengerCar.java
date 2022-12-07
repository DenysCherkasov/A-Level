package com.cherkasov.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class PassengerCar extends Car implements CountRestore {
    private int passengerCount;

    public PassengerCar(String manufacturer, Engine engine, Color color, int passengerCount) {
        super(manufacturer, engine, color);
        this.passengerCount = passengerCount;
    }

    public PassengerCar(int passengerCount) {
        this.passengerCount = passengerCount;
    }

    @Override
    public void restore() {
        setCount(100);
        System.out.println(getCount());
    }
}
