package com.cherkasov.container;

import com.cherkasov.model.Car;

import java.util.Comparator;

public class CarComparator implements Comparator <Car> {
    @Override
    public int compare(Car o1, Car o2) {
        Integer firstCar = o1.getCount();
        Integer secondCar = o2.getCount();
        return firstCar.compareTo(secondCar);
    }
}
