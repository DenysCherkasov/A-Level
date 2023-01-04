package com.cherkasov.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class PassengerCar extends Car {
    private int passengerCount;

    public PassengerCar(String manufacturer, Engine engine, Color color, int passengerCount) {
        super(manufacturer, engine, color, Type.PASSENGERCAR);
        this.passengerCount = passengerCount;
    }

    public PassengerCar() {
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

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

}
