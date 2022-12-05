package com.cherkasov.repository;

import com.cherkasov.model.Color;
import com.cherkasov.model.PassengerCar;

public class CarArrayRepository {
    private static PassengerCar[] passengerCars = new PassengerCar[10];

    public void save(PassengerCar passengerCar) {
        final int index = putCar(passengerCar);
        if (index == passengerCars.length) {
            int oldlength = passengerCars.length;
            increaseArray();
            passengerCars[oldlength] = passengerCar;
        }
    }

    public PassengerCar[] getAll() {
        final int newLength = foundLength();
        final PassengerCar[] PassengerNewCars = new PassengerCar[newLength];
        System.arraycopy(passengerCars, 0, PassengerNewCars, 0, newLength);
        return PassengerNewCars;
    }

    public PassengerCar getById(final String id) {
        for (PassengerCar passengerCar : passengerCars) {
            if (passengerCar.getId().equals(id)) {
                return passengerCar;
            }
        }
        return null;
    }

    public void delete(final String id) {
        int index = 0;
        for (; index < passengerCars.length; index++) {
            if (passengerCars[index].getId().equals(id)) {
                break;
            }
        }
        if (index != passengerCars.length) {
            System.arraycopy(passengerCars, index + 1, passengerCars, index,
                    passengerCars.length - (index + 1));
        }
    }

    public void updateColor(final String id, final Color color) {
        final PassengerCar passengerCar = getById(id);
        if (passengerCar != null) {
            passengerCar.setColor(color);
        }
    }


    private int putCar(PassengerCar passengerCar) {
        int index = 0;
        for (; index < passengerCars.length; index++) {
            if (passengerCars[index] == null) {
                passengerCars[index] = passengerCar;
                break;
            }
        }
        return index;
    }

    private void increaseArray() {
        PassengerCar[]  passengernewCars = new PassengerCar[passengerCars.length * 2];
        System.arraycopy(passengerCars, 0, passengernewCars, 0, passengerCars.length);
        passengerCars = passengernewCars;
    }

    public int foundLength() {
        int newLength = 0;
        for (PassengerCar passengerCar : passengerCars) {
            if (passengerCar != null) {
                newLength++;
            } else {
                break;
            }
        }
        return newLength;
    }

    public void insert(int index, final PassengerCar passengerCar) {
        int emptyIndex = findEmptyIndex(passengerCars);
        if (emptyIndex == -1) {
            save(passengerCar);
        } else {
            if (index >= emptyIndex) {
                save(passengerCar);
            } else {
                putCarByIndex(index, passengerCar, passengerCars);
            }
        }
    }

    public int findEmptyIndex(PassengerCar[] passengerCars) {
        int emptyIndex = -1;
        for (int i = 0; i < passengerCars.length; i++) {
            if (passengerCars[i] != null) {
                emptyIndex = i;
            }
        }
        return emptyIndex;
    }

    public void putCarByIndex(int index, final PassengerCar passengerCar, PassengerCar[] passengerCars) {
        System.arraycopy(passengerCars, index, passengerCars, index + 1,
                passengerCars.length - (index + 1));
        passengerCars[index] = passengerCar;
    }
}