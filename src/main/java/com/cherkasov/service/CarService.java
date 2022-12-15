package com.cherkasov.service;

import com.cherkasov.model.*;
import com.cherkasov.repository.CarArrayRepository;
import com.cherkasov.util.RandomGenerator;
import com.cherkasov.util.UserInputException;

import java.util.Arrays;
import java.util.Optional;
import java.util.Random;

public class CarService {
    private final CarArrayRepository carArrayRepository;
    private final Random random = new Random();
    private final RandomGenerator randomGenerator = new RandomGenerator();

    public CarService(final CarArrayRepository carArrayRepository) {
        this.carArrayRepository = carArrayRepository;
    }

    public Car create(Type type) {
        Engine engine = new Engine(getRandomString());
        Car car;
        if (type != Type.PASSENGERCAR && type != Type.TRUCK) {
            type = getRandomType();
        }
        if (type == Type.PASSENGERCAR) {
            car = new PassengerCar(getRandomString(),
                    engine, getRandomColor(),
                    randomGenerator.getRandomNumber());
        } else {
            car = new Truck(getRandomString(),
                    engine, getRandomColor(),
                    randomGenerator.getRandomNumber());
        }
        carArrayRepository.save(car);
        return car;
    }

    // tested //
    public void createWithCount(final int count) {
        for (int i = 0; i < count; i++) {
            create(getRandomType());
        }
    }

    // tested //
    public int createWithRandomCount(final RandomGenerator randomGenerator) {
        int count = randomGenerator.getRandomNumber();
        if (randomGenerator == null || count <= 0 || count > 10) {
            return -1;
        } else {
            for (int i = 0; i < count; i++) {
                print(create(getRandomType()));
            }
        }
        return count;
    }

    public boolean carEquals(final Car firstCar, final Car secondCar) {
        if (firstCar == null || secondCar == null ||
                firstCar.getType() != secondCar.getType() ||
                firstCar.hashCode() != secondCar.hashCode()) {
            return false;
        }
        return firstCar.equals(secondCar);
    }

    //tested//
    public void insert(int index, final Car car) {
        if (index < 0 || car == null) {
            return;
        }
        carArrayRepository.insert(index, car);
    }

    //tested//
    public static void check(Car car) {
        if (car.getCount() >= 1 && (car.getEngine().getPower() > 200)) {
            System.out.println("The car is ready for sale");
        } else if (car.getCount() < 1 && (car.getEngine().getPower() > 200)) {
            System.out.println("The count of the car = 0");
        } else if (car.getCount() >= 1 && (car.getEngine().getPower() <= 200)) {
            System.out.println("The engine power of the car is less than 200");
        } else {
            System.out.println("The count of the car = 0 and the engine power " +
                    "of the car is less than 200");
        }
    }

    // tested //
    public void print(Car car) {
        System.out.println(car.toString());
    }

    // tested //
    public void printAll() {
        final Car[] all = carArrayRepository.getAll();
        System.out.println(Arrays.toString(all));
    }

    //tested//
    public Car[] getAll() {
        return carArrayRepository.getAll();
    }

    //tested//
    public Car find(final String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        return carArrayRepository.getById(id);
    }

    //tested//
    public void delete(final String id) {
        if (id == null || id.isEmpty()) {
            return;
        }
        carArrayRepository.delete(id);
    }

    private Color getRandomColor() {
        final Color[] values = Color.values();
        final int randomIndex = random.nextInt(values.length);
        return values[randomIndex];
    }

    private Type getRandomType() {
        final Type[] values = Type.values();
        final int randomIndex = random.nextInt(values.length);
        return values[randomIndex];
    }


    public void changeRandomColor(final String id) {
        if (id == null || id.isEmpty()) {
            return;
        }
        final Car car = find(id);
        if (car == null) {
            return;
        }
        findAndChangeRandomColor(car);
    }

    private void findAndChangeRandomColor(final Car car) {
        final Color color = car.getColor();
        Color randomColor;
        do {
            randomColor = getRandomColor();
        } while (randomColor == color);
        carArrayRepository.updateColor(car.getId(), randomColor);
    }

    //tested//
    public String getRandomString() {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        int length = random.nextInt(5, 10);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    public void printManufacturerAndCount(final Car car) {
        Optional.ofNullable(car).ifPresent(ManufacturerAndCount -> {
            System.out.println("Manufacturer: " + car.getManufacturer() +
                    ", Count: " + car.getCount());
        });
    }

    public void printColor(final Car car) {
        Car newCar = Optional.ofNullable(car).orElse(new PassengerCar(getRandomString(),
                new Engine(getRandomString()), getRandomColor(),
                randomGenerator.getRandomNumber()));
        System.out.println("Color: " + newCar.getColor());
    }

    public void printEngineInfo(final Car car) {
        Car newCar = Optional.ofNullable(car)
                .orElseGet(() -> create(Type.PASSENGERCAR));
        System.out.println("Engine: " + newCar.getEngine());
    }

    public void printInfo(final Car car) {
        Optional.ofNullable(car)
                .ifPresentOrElse(
                        newCar -> {
                            System.out.println("Car: " + newCar);
                        },
                        () -> {
                            Car newCar = create(Type.PASSENGERCAR);
                            System.out.println("New car: " + newCar);
                        });
    }

    public void checkCount(final Car car) {
        Optional.ofNullable(car).filter(count -> car.getCount() > 10)
                .orElseThrow(UserInputException::new);
        System.out.println("Manufacturer: " +
                car.getManufacturer() + ", Count: " + car.getCount());

    }

    public void checkCount2(final Car car) {
        Optional<Car> carOptional = Optional.ofNullable(car);
        Optional.ofNullable(car)
                .ifPresent(type -> {
                    carOptional.filter(count -> {
                                final boolean b = car.getCount() > 10;
                                if (b) {
                                    System.out.println("Manufacturer: " +
                                            count.getManufacturer() +
                                            ", Count: " + count.getCount());
                                }
                                return b;
                            })
                            .orElseThrow(UserInputException::new);
                });
    }

}

