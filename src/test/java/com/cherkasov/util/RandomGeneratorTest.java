package com.cherkasov.util;

import com.cherkasov.model.Car;
import com.cherkasov.repository.CarArrayRepository;
import com.cherkasov.service.CarService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Random;

public class RandomGeneratorTest {
    private RandomGenerator target = new RandomGenerator();
    private int carsNumber;

    @Test
    void getRandomNumber() {
        Assertions.assertDoesNotThrow(() -> target.getRandomNumber());
    }

    @Test
    void getRandomNumberNull() {
        carsNumber = target.getRandomNumber();
        Assertions.assertNotNull(carsNumber);
    }

    @Test
    void getRandomNumberIncorrectLess() {
        carsNumber = target.getRandomNumber();
        boolean Incorrect = carsNumber < 0;
        Assertions.assertFalse(Incorrect);
    }

    @Test
    void getRandomNumberIncorrectMore() {
        carsNumber = target.getRandomNumber();
        boolean Incorrect = carsNumber > 10;
        Assertions.assertFalse(Incorrect);
    }
}
