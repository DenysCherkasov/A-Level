package com.cherkasov.service;

import com.cherkasov.model.Car;

import java.util.Random;

public class CarService {
    public static String getRandomString() {
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

    public static Car create() {
        Car car = new Car(getRandomString(), getRandomString(), getRandomString());
        return car;
    }

    public static void print(Car car) {
        String carInfo = String.format("{Manufacturer: %s, Engine: %s, Color: %s, Count; %s, Price; %s}",
                car.getManufacturer(), car.getEngine(), car.getColor(), car.getCount(), car.getPrice());
        System.out.println(carInfo);
    }
}
