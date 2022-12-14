package com.cherkasov.repository;

import com.cherkasov.model.Car;
import com.cherkasov.model.Color;

import java.util.Optional;

public class CarArrayRepository<T extends Car> implements RepositoryInterface <T>{
    private static Car[] cars = new Car[10];

    private static CarArrayRepository instance;

    private CarArrayRepository() {
    }

    public static CarArrayRepository getInstance() {
        if (instance == null) {
            instance = new CarArrayRepository();
        }
        return instance;
    }


    public void save(Car car) {
        final int index = putCar(car);
        if (index == cars.length) {
            int oldlength = cars.length;
            increaseArray();
            cars[oldlength] = car;
        }
    }

    public Car[] getAll() {
        final int newLength = foundLength();
        final Car[] newCars = new Car[newLength];
        System.arraycopy(cars, 0, newCars, 0, newLength);
        return newCars;
    }

    public Optional<Car> getById(final String id) {
        for (Car car : cars) {
            if (car.getId().equals(id)) {
                return Optional.ofNullable(car);
            }
        }
        return null;
    }

    public void delete(final String id) {
        int index = 0;
        for (; index < cars.length; index++) {
            if (cars[index].getId().equals(id)) {
                break;
            }
        }
        if (index != cars.length) {
            System.arraycopy(cars, index + 1, cars, index,
                    cars.length - (index + 1));
        }
    }

    public void updateColor(final String id, final Color color) {
        getById(id)
                .ifPresent(car -> car.setColor(color));
    }


    private int putCar(Car passengerCar) {
        int index = 0;
        for (; index < cars.length; index++) {
            if (cars[index] == null) {
                cars[index] = passengerCar;
                break;
            }
        }
        return index;
    }

    private void increaseArray() {
        Car[] newCars = new Car[cars.length * 2];
        System.arraycopy(cars, 0, newCars, 0, cars.length);
        cars = newCars;
    }

    public int foundLength() {
        int newLength = 0;
        for (Car car : cars) {
            if (car != null) {
                newLength++;
            } else {
                break;
            }
        }
        return newLength;
    }

    public void insert(int index, final Car car) {
        int emptyIndex = findEmptyIndex(cars);
        if (emptyIndex == -1) {
            save(car);
        } else {
            if (index >= emptyIndex) {
                save(car);
            } else {
                putCarByIndex(index, car, cars);
            }
        }
    }

    public int findEmptyIndex(Car[] cars) {
        int emptyIndex = -1;
        for (int i = 0; i < cars.length; i++) {
            if (cars[i] != null) {
                emptyIndex = i;
            }
        }
        return emptyIndex;
    }

    public void putCarByIndex(int index, final Car car, Car[] cars) {
        System.arraycopy(cars, index, cars, index + 1,
                cars.length - (index + 1));
        cars[index] = car;
    }
}
