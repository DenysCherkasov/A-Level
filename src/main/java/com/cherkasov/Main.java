package com.cherkasov;

import com.cherkasov.model.Car;
import com.cherkasov.repository.CarArrayRepository;
import com.cherkasov.service.CarService;
import com.cherkasov.util.RandomGenerator;

public class Main {
    public static void main(String[] arg) {
        CarService carService = new CarService(new CarArrayRepository());
        Car firstCar = carService.createWithoutCount();
        RandomGenerator randomGenerator = new RandomGenerator();
        Car secondCar = carService.createWithoutCount();
        Car thirdCar = carService.createWithoutCount();
        carService.print(firstCar);
        carService.print(secondCar);
        CarService.check(secondCar);
        carService.print(thirdCar);
        carService.check(thirdCar);
        System.out.println("");
        carService.createWithRandomCount(randomGenerator);
        carService.printAll();
    }
}
