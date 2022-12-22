package com.cherkasov.repository;

import com.cherkasov.model.Car;
import com.cherkasov.model.Color;

interface RepositoryInterface <T extends Car> {
    void save(Car car);

    Car[] getAll();

    Car getById(final String id);

    void delete(final String id);

    void updateColor(final String id, final Color color);

    int foundLength();

    void insert(int index, final Car car);

    int findEmptyIndex(Car[] cars);

    void putCarByIndex(int index, final Car car, Car[] cars);
}
