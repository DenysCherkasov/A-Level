package com.cherkasov.service;

import com.cherkasov.model.Car;
import com.cherkasov.model.Color;
import com.cherkasov.repository.CarArrayRepository;
import com.cherkasov.util.RandomGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Random;

class CarServiceTest {
    private CarService target;
    private CarArrayRepository repository;
    private RandomGenerator randomGenerator;
    private Car car;
    Random random = new Random();


    @BeforeEach
    void setUp() {
        repository = Mockito.mock(CarArrayRepository.class);
        target = new CarService(repository);
        randomGenerator = Mockito.mock(RandomGenerator.class);
        car = new Car();
    }

    @Test
    void createWithoutCount() {
        final Car car = target.createWithoutCount();
        Assertions.assertNotNull(car);
    }

    @Test
    void createWithCount() {
        int expected = 3;
        Assertions.assertDoesNotThrow(() -> target.createWithCount(expected));
    }

    @Test
    void createWithCountZero() {
        int expected = 0;
        Assertions.assertDoesNotThrow(() -> target.createWithCount(expected));
    }

    @Test
    void createWithCountNegative() {
        int expected = -12;
        Assertions.assertDoesNotThrow(() -> target.createWithCount(expected));
    }

    @Test
    void createWithRandomCount() {
        int expected = 5;
        Mockito.when(randomGenerator.getRandomNumber()).thenReturn(5);
        int actual = randomGenerator.getRandomNumber();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void createWithRandomCountIncorrectCount() {
        int expected = -1;
        Mockito.when(randomGenerator.getRandomNumber()).thenReturn(-1);
        int actual = randomGenerator.getRandomNumber();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void createWithRandomCountRandomNumberNull() {
        Assertions.assertDoesNotThrow(() -> target.insert(-13, car));
    }

    @Test
    void insert() {
        Assertions.assertDoesNotThrow(() -> target.insert(5, car));
    }

    @Test
    void insertCarNull() {
        Assertions.assertDoesNotThrow(() -> target.insert(5, null));
    }

    @Test
    void insertIncorrectIndex() {
        Assertions.assertDoesNotThrow(() -> target.insert(-5, car));
    }

    @Test
    void print() {
        Assertions.assertDoesNotThrow(() -> target.print(car));
    }

    @Test
    void printAll() {
        Assertions.assertDoesNotThrow(() -> target.printAll());
    }

    @Test
    void getAll() {
        Assertions.assertDoesNotThrow(() -> target.getAll());
    }

    @Test
    void check() {
        car = target.createWithoutCount();
        Assertions.assertDoesNotThrow(() -> target.check(car));
    }

    @Test
    void FindIdIncorrectNull() {
        String id = null;
        final Car car = target.find(id);
        Assertions.assertNull(car);
    }

    @Test
    void FindIdIncorrectEmpty() {
        String id = "123";
        Mockito.when(repository.getById("123")).thenReturn(null);
        final Car car = target.find(id);
        Assertions.assertNull(car);
    }

    @Test
    void Find() {
        final Car expected = new Car();
        String id = "123";
        Mockito.when(repository.getById("123")).thenReturn(expected);
        final Car actual = target.find(id);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void deleteIdNull () {
        target.delete(null);
        Mockito.verify(repository, Mockito.never()).delete(Mockito.anyString());
    }

    @Test
    void deleteIdEmpty () {
        target.delete("");
        Mockito.verify(repository, Mockito.never()).delete(Mockito.anyString());
    }

    @Test
    void delete () {
        final String id = "123";
        target.delete(id);
        Mockito.verify(repository).delete(id);
    }

    @Test
    void getRandomColorNotNull() {
        Color[] actual = Color.values();
        Assertions.assertNotNull(actual);
    }

    @Test
    void getRandomColorIndexNull() {
        Color[] values = new Color[5];
        final int randomIndex = random.nextInt(values.length);
        Assertions.assertNotNull(randomIndex);
    }

    @Test
    void getRandomColorNull() {
        Color[] values = null;
        Assertions.assertNull(values);
    }

    @Test
    void getRandomString() {
        String actual = target.getRandomString();
        Assertions.assertNotNull(actual);
    }

    @Test
    void changeRandomColor() {
        String id = "123";
        Assertions.assertDoesNotThrow(() -> target.changeRandomColor(id));
    }

    @Test
    void changeRandomColorIncorrectIdNull() {
        String id = null;
        Assertions.assertDoesNotThrow(() -> target.changeRandomColor(id));
    }

    @Test
    void changeRandomColorIncorrectIdEmpty() {
        String id = "";
        Assertions.assertDoesNotThrow(() -> target.changeRandomColor(id));
    }

}
