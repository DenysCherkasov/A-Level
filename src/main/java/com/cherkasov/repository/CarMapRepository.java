package com.cherkasov.repository;

import com.cherkasov.model.Car;
import com.cherkasov.service.CarService;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiPredicate;

public class CarMapRepository implements RepositoryInterface<Car> {
    private static final Map<String, Car> CARS = new HashMap<>();
    private static CarMapRepository instance;
    private static final BiPredicate<String, String> CHECK_ID = (checkingId, id) -> checkingId.equals(id);

    private CarMapRepository() {
    }

    public static CarMapRepository getInstance() {
        if (instance == null) {
            instance = new CarMapRepository();
        }
        return instance;
    }

    @Override
    public void save(final Car car) {
        if (car != null && !CARS.containsKey(car.getId())) {
            CARS.put(car.getId(), car);
        }
    }

    @Override
    public Car[] getAll() {
        return CARS.values().toArray(new Car[0]);
    }

    @Override
    public Optional<Car> getById(final String id) {
        if (id != null && CARS.containsKey(id)) {
            return Optional.ofNullable(CARS.get(id));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void delete(final String id) {
        CARS.remove(id);
    }
}
