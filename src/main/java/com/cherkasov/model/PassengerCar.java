package com.cherkasov.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class PassengerCar extends Car implements CountRestore {
    private int passengerCaunt;

    public PassengerCar(String manufacturer, Engine engine, Color color, int passengerCaunt) {
        super(manufacturer, engine, color);
        this.passengerCaunt = passengerCaunt;
    }

    public PassengerCar(int passengerCaunt) {
        this.passengerCaunt = passengerCaunt;
    }

    @Override
    public void restore() {
        setCount(100);
        System.out.println(getCount());
    }
}
