package com.cherkasov;

import com.cherkasov.repository.CarArrayRepository;
import com.cherkasov.service.CarService;

public class Main {
    public static void main(String[] arg) {
        CarService carService = new CarService(new CarArrayRepository());
        carService.createPassengerCar();
        carService.createTruck();
        Car firstCar = carService.create();
        Car secondCar = carService.create();
        Car thirdCar = carService.create();
        carService.check(firstCar);
        carService.check(secondCar);
        carService.check(thirdCar);
        carService.create(3);
        carService.printAll();
        carService.insert(6, firstCar);
        carService.printAll();
    }
}
