package com.cherkasov.container;

import com.cherkasov.model.Car;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Setter
@Getter
public class GenericContainer<T extends Car> {
    private static Random random = new Random();
    private T car;

    public GenericContainer(final T car) {
        this.car = car;
    }

    public void print() {
        System.out.println(car);
    }

    public void increaseCount() {
        car.setCount(car.getCount() +
                random.nextInt(100, 300));
    }

    public <T extends Number> void increaseCount(T number) {
        car.setCount(car.getCount() + number.intValue());
    }
}
