package com.cherkasov.service;

import com.cherkasov.model.Color;
import com.cherkasov.model.Engine;
import com.cherkasov.model.PassengerCar;
import com.cherkasov.model.Truck;
import com.cherkasov.repository.CarArrayRepository;
import com.cherkasov.util.RandomGenerator;

import java.util.Arrays;
import java.util.Random;

public class CarService {
    private final CarArrayRepository carArrayRepository;
    private final Random random = new Random();
    private final RandomGenerator randomGenerator = new RandomGenerator();
    public CarService(final CarArrayRepository carArrayRepository) {
        this.carArrayRepository = carArrayRepository;
    }

    // tested //

    public PassengerCar createWithoutCount() {
        Engine engine = new Engine(getRandomString());
        PassengerCar passengerCar = new PassengerCar (getRandomString(), engine, getRandomColor(), randomGenerator.getRandomNumber());
        carArrayRepository.save(passengerCar);
        return passengerCar;
    }

    // tested //
    public void createWithCount(final int count) {
        for (int i = 0; i < count; i++) {
            createWithoutCount();
        }
    }

    // tested //
    public int createWithRandomCount(final RandomGenerator randomGenerator) {
        int count = randomGenerator.getRandomNumber();
        if (randomGenerator == null || count <= 0 || count > 10) {
            return -1;
        } else {
            for (int i = 0; i < count; i++) {
                print(createWithoutCount());
            }
        }
        return count;
    }

    public PassengerCar createPassengerCar() {
        Engine engine = new Engine(getRandomString());
        PassengerCar passengerCar = new PassengerCar (getRandomString(), engine, getRandomColor(), randomGenerator.getRandomNumber());
        carArrayRepository.save(passengerCar);
        return passengerCar;
    }

    public Truck createTruck() {
        Engine engine = new Engine(getRandomString());
        Truck truck = new Truck (getRandomString(), engine, getRandomColor(), randomGenerator.getRandomNumber());
        return truck;
    }



    //tested//
    public void insert(int index, final PassengerCar passengerCar) {
        if (index < 0 || passengerCar == null) {
            return;
        }
        carArrayRepository.insert(index, passengerCar);
    }

    //tested//
    public static void check(PassengerCar passengerCar) {
        if (passengerCar.getCount() >= 1 && (passengerCar.getEngine().getPower() > 200)) {
            System.out.println("The car is ready for sale");
        } else if (passengerCar.getCount() < 1 && (passengerCar.getEngine().getPower() > 200)) {
            System.out.println("The count of the car = 0");
        } else if (passengerCar.getCount() >= 1 && (passengerCar.getEngine().getPower() <= 200)) {
            System.out.println("The engine power of the car is less than 200");
        } else {
            System.out.println("The count of the car = 0 and the engine power of the car is less than 200");
        }
    }

    // tested //
    public void print(PassengerCar passengerCar) {
        System.out.println(passengerCar.toString());
    }

    // tested //
    public void printAll() {
        final PassengerCar[] all = carArrayRepository.getAll();
        System.out.println(Arrays.toString(all));
    }

    //tested//
    public PassengerCar[] getAll() {
        return carArrayRepository.getAll();
    }

    //tested//
    public PassengerCar find(final String id) {
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


    public void changeRandomColor(final String id) {
        if (id == null || id.isEmpty()) {
            return;
        }
        final PassengerCar passengerCar = find(id);
        if (passengerCar == null) {
            return;
        }
        findAndChangeRandomColor(passengerCar);
    }

    private void findAndChangeRandomColor(final PassengerCar passengerCar) {
        final Color color = passengerCar.getColor();
        Color randomColor;
        do {
            randomColor = getRandomColor();
        } while (randomColor == color);
        carArrayRepository.updateColor(passengerCar.getId(), randomColor);
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
}
