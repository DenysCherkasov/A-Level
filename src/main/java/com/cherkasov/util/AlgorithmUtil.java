package com.cherkasov.util;

import com.cherkasov.model.Car;

public class AlgorithmUtil {
    public static Car[] bubbleSortCars(Car[] cars) {
        if (cars != null) {
            for (int i = 0; i < cars.length - 1; i++)
                for (int j = 0; j < cars.length - i - 1; j++)
                    if (cars[j] != null && cars[j + 1] != null &&
                            cars[j].getId().compareTo(cars[j + 1].getId()) > 0) {
                        Car temp = cars[j];
                        cars[j] = cars[j + 1];
                        cars[j + 1] = temp;
                    }
            return cars;
        } else {
            System.out.println("This array is null");
            return cars;
        }
    }

    public static void printCarsArray(Car[] cars) {
        if (cars != null) {
            for (int i = 0; i < cars.length; i++) {
                System.out.printf("ID: %s, Type: %s, " +
                                "Manufacturer: %s, Engine: %s, " +
                                "Color: %s, Count; %s, Price; %s%n",
                        cars[i].getId(), cars[i].getType(), cars[i].getManufacturer(),
                        cars[i].getEngine(), cars[i].getColor(), cars[i].getCount(),
                        cars[i].getPrice());
            }
        } else {
            System.out.println("This array is null");
        }
    }

    public static int binarySearchCar(Car[] cars, Car carToSearch) {
        if (cars != null && carToSearch != null) {
            int index = 123456;
            int firstIndex = 0;
            int lastIndex = cars.length - 1;
            while (firstIndex <= lastIndex) {
                int mid = firstIndex + ((lastIndex - firstIndex) / 2);
                if (cars[mid].getId().compareTo(carToSearch.getId()) < 0) {
                    firstIndex = mid + 1;
                } else if (cars[mid].getId().compareTo(carToSearch.getId()) > 0) {
                    lastIndex = mid - 1;
                } else if (cars[mid].getId().compareTo(carToSearch.getId()) == 0) {
                    index = mid;
                }
                return index;
            }
        }
        return -1;
    }
}


