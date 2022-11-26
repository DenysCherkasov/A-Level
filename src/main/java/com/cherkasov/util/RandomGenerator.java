package com.cherkasov.util;

import java.util.Random;

public class RandomGenerator {
    Random random = new Random();
    public int getRandomNumber() {
        int carsNumber = random.nextInt(10);
        return carsNumber;
    }

}
