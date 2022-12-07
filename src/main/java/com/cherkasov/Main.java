package com.cherkasov;

import com.cherkasov.model.Car;
import com.cherkasov.model.Type;
import com.cherkasov.repository.CarArrayRepository;
import com.cherkasov.service.CarService;

public class Main {
    public static void main(String[] arg) {
        CarService carService = new CarService(new CarArrayRepository());
        carService.create(Type.TRUCK);
        carService.create(Type.PASSENGERCAR);
        carService.printAll();
        Car car = carService.create(Type.PASSENGERCAR);
        System.out.println(carService.carEquals(carService.create(Type.TRUCK),
                carService.create(Type.TRUCK)));
        System.out.println(carService.carEquals(car, car));
    }
}
