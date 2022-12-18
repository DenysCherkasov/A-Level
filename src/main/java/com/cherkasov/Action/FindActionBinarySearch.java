package com.cherkasov.Action;

import com.cherkasov.model.Car;
import com.cherkasov.util.AlgorithmUtil;
import com.cherkasov.util.UserInput;

public class FindActionBinarySearch implements Action {
    @Override
    public void execute() {
        System.out.println("Index of which car do we need to search?");
        Car[] cars = CAR_SERVICE.getAll();
        String[] carsToString = new String[cars.length];
        for (int i = 0; i < cars.length; i++) {
            carsToString[i] = cars[i].toString();
        }
        final int userChoice = UserInput.menu(carsToString);
        AlgorithmUtil.bubbleSortCars(cars);
        int index = AlgorithmUtil.binarySearchCar(cars, cars[userChoice]);
        System.out.println("Index of this car: " + index);
    }
}