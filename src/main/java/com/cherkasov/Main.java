package com.cherkasov;

import com.cherkasov.model.Car;
import com.cherkasov.model.Type;
import com.cherkasov.repository.CarArrayRepository;
import com.cherkasov.service.CarService;

public class Main {
    public static void main(String[] arg) {
        CarService carService = new CarService(new CarArrayRepository());
        // carService.create(Type.TRUCK);
        //   carService.create(Type.PASSENGERCAR);
        //   carService.printAll();
        Car car = carService.create(Type.PASSENGERCAR);
        //   System.out.println(carService.carEquals(carService.create(Type.TRUCK),
        //           carService.create(Type.TRUCK)));
        //   System.out.println(carService.carEquals(car, car));
        //   System.out.println(car.toString());

        Car carNull = null;
        carService.printManufacturerAndCount(car);
        carService.printManufacturerAndCount(carNull);

        carService.printColor(car);
        carService.printColor(carNull);

        carService.printEngineInfo(car);
        carService.printEngineInfo(carNull);

        carService.printInfo(car);
        carService.printInfo(carNull);

        carService.checkCount2(carNull);
        car.setCount(15);
        carService.checkCount2(car);
        carService.checkCount2(carService.create(Type.TRUCK));

        carService.checkCount(car);
        carService.checkCount(carNull);
        carService.checkCount2(carService.create(Type.TRUCK));


    }

}
