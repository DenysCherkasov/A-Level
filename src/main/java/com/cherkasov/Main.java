package com.cherkasov;

import com.cherkasov.repository.CarArrayRepository;
import com.cherkasov.service.CarService;

public class Main {
    public static void main(String[] arg) {
        CarService carService = new CarService(new CarArrayRepository());
        carService.createPassengerCar();
        carService.createTruck();
        carService.printAll();
    }
}
