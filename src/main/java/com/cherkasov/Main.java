package com.cherkasov;

import com.cherkasov.model.Car;
import com.cherkasov.repository.CarArrayRepository;
import com.cherkasov.service.CarService;

public class Main {
    public static void main(String[] arg) {
        CarService carService = new CarService(new CarArrayRepository());
        Car firstCar = carService.create();
        Car secondCar = carService.create();
        Car thirdCar = carService.create();
        carService.print(firstCar);
        carService.check(firstCar);
        carService.print(secondCar);
        carService.check(secondCar);
        carService.print(thirdCar);
        carService.check(thirdCar);
        carService.create(3);
        carService.printAll();
        carService.insert(1, firstCar);
        carService.printAll();
    }
}
