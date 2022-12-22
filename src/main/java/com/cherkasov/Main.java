package com.cherkasov;

import com.cherkasov.Action.Actions;
import com.cherkasov.container.CarList;
import com.cherkasov.container.GenericContainer;
import com.cherkasov.model.Car;
import com.cherkasov.model.Type;
import com.cherkasov.repository.CarArrayRepository;
import com.cherkasov.service.CarService;
import com.cherkasov.util.AlgorithmUtil;
import com.cherkasov.util.UserInput;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] arg) {
        CarService carService = CarService.getInstance();
        // carService.create(Type.TRUCK);
        //   carService.create(Type.PASSENGERCAR);
        //   carService.printAll();
        //   System.out.println(carService.carEquals(carService.create(Type.TRUCK),
        //           carService.create(Type.TRUCK)));
        //   System.out.println(carService.carEquals(car, car));
        //   System.out.println(car.toString());

        /*carService.printManufacturerAndCount(car);
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
*/
//        carService.createWithCount(8);
//        carService.printAll();
//        Car[] sortedCars = AlgorithmUtil
//                .bubbleSortCars(carService.getAll());
//        AlgorithmUtil.printCarsArray(sortedCars);
//
//        System.out.println("Index of this car: " + AlgorithmUtil.binarySearchCar(sortedCars, car));
//GenericContainer<Car> genericContainer = new GenericContainer<>(carService.create(Type.TRUCK));
//        genericContainer.print();
//        genericContainer.increaseCount();
//        genericContainer.print();
//        genericContainer.increaseCount(5.5);
//        genericContainer.print();

//       final Actions[] values = Actions.values();
//        final String[] names = mapActionToName(values);
//
//        while (true) {final int userChoice = UserInput.menu(names);
//            values[userChoice].execute();
//        }
//
//    }
//    private static String[] mapActionToName (final Actions[] values) {
//        String[] names = new String[values.length];
//        for (int i = 0; i < values.length; i++) {
//            names[i] = values[i].getName();
//        }
//        return names;
//    }


        CarList<Car> carList = new CarList<>();

        carList.add(0, carService.create(Type.TRUCK));
        carList.addLast(carService.create(Type.PASSENGERCAR));
        carList.addLast(carService.create(Type.TRUCK));
        carList.addLast(carService.create(Type.PASSENGERCAR));
        carList.add(carService.create(Type.TRUCK));
        System.out.println(carList.size());
        Iterator<Car> iterator = carList.iterator();
        while (iterator.hasNext()) {
            Car car1 = iterator.next();
            System.out.println(car1);
        }

        carList.addFirst(carService.create(Type.PASSENGERCAR));
        System.out.println(carList.size());
        for (int i = 0; i < carList.size(); i++) {
            System.out.println(carList.get(i).toString());
        }

        carList.remove(3);
        System.out.println(carList.size());
        for (int i = 0; i < carList.size(); i++) {
            System.out.println(carList.get(i).toString());
        }
        Car car = carService.create(Type.PASSENGERCAR);
        carList.addLast(car);
        System.out.println(carList.indexOf(car));




    }
}
