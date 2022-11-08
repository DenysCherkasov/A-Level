package com.cherkasov;

import com.cherkasov.model.Car;
import com.cherkasov.service.CarService;

public class Main {
    public static void main(String[] arg) {
        Car firstCar = CarService.create();
        Car secondCar = CarService.create();
        Car thirdCar = CarService.create();
        CarService.print(firstCar);
        CarService.print(secondCar);
        CarService.print(thirdCar);
    }
}
