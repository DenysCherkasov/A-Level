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
        super(manufacturer, engine, color, Type.PASSENGERCAR);
        this.passengerCount = passengerCount;
    }

    public PassengerCar(int passengerCount) {
        this.passengerCount = passengerCount;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Passenger count: %s%n", passengerCount);
    }

    @Override
    public void restore() {
        setCount(100);
        System.out.println(getCount());
    }
}
