package com.cherkasov.repository;

import com.cherkasov.model.Car;
import com.cherkasov.model.Color;

import java.util.Optional;

interface RepositoryInterface <T extends Car> {
    void save(Car car);

    Car[] getAll();

    Optional<Car> getById(final String id);

    void delete(final String id);

//    void insert(int index, final Car car);

}
