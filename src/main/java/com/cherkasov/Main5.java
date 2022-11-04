package com.cherkasov;

import java.util.Arrays;
import java.util.Random;

public class Main5 {
    public static void main(String[] args) {
        // Task 1 //
        Random random = new Random();
        int[] numbers = new int[12];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(-15, 15);
        }
        System.out.println("Init array: " + Arrays.toString(numbers));
        int max = Integer.MIN_VALUE;
        int lastIndexMax = 0;
        for (int i = 0; i < numbers.length; i++) {
            max = Math.max(max, numbers[i]);
            if (numbers[i] == max) {
                lastIndexMax = i;
            }
        }
        System.out.println("Max number " + max);
        System.out.println("Last index of " + max + " in the array is " + lastIndexMax);
        // Task 2 //
        Random random2 = new Random();
        int[] numbers2 = new int[8];
        for (int i = 0; i < numbers2.length; i++) {
            numbers2[i] = random2.nextInt(1, 10);
        }
        System.out.println("Init array: " + Arrays.toString(numbers2));
        for (int i = 0; i < numbers2.length; i++) {
            if (i % 2 != 0) {
                numbers2[i] = 0;
            }
        }
        System.out.println("Changed array: " + Arrays.toString(numbers2));
        // Task 3 //
        Random random3 = new Random();
        int[] numbers3 = new int[4];
        for (int i = 0; i < numbers3.length; i++) {
            numbers3[i] = random3.nextInt(10, 99);
        }
        System.out.println("Init array: " + Arrays.toString(numbers3));
        int[] newNumbers = Arrays.stream(numbers3).toArray();
        Arrays.sort(newNumbers);
        boolean comparison = Arrays.equals(numbers3, newNumbers);
        System.out.println("Does this array have a strictly growing sequence? " + comparison);
        // Task 4 //
        Random random4 = new Random();
        int[] firstArray = new int[5];
        for (int i = 0; i < firstArray.length; i++) {
            firstArray[i] = random4.nextInt(0, 5);
        }
        int[] secondArray = new int[5];
        for (int i = 0; i < secondArray.length; i++) {
            secondArray[i] = random4.nextInt(0, 5);
        }
        System.out.printf("First array: %s%n" + "Second array: %s%n",
                Arrays.toString(firstArray), Arrays.toString(secondArray));
        double total1 = 0.0D;
        for (int element : firstArray) {
            total1 += element;
        }
        double average1 = total1 / firstArray.length;
        System.out.println(average1);
        double total2 = 0.0D;
        for (int element : secondArray) {
            total2 += element;
        }
        double average2 = total2 / secondArray.length;
        System.out.println(average2);
        if (average1 > average2) {
            System.out.println("Average of first array > average of second array");
        } else if (average1 < average2) {
            System.out.println("Average of first array < average of second array");
        } else {
            System.out.println("Average of first array = average of first array");
        }
        // Optional task //
        final Random random5 = new Random();
        final int[] numbers5 = new int[10];
        for (int i = 0; i < numbers5.length; i++) {
            numbers5[i] = random5.nextInt(100);
        }
        System.out.println("Unsorted array: " + Arrays.toString(numbers5));
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < numbers5.length - 1; i++) {
                if (numbers5[i] > numbers5[i + 1]) {
                    int temp = numbers5[i];
                    numbers5[i] = numbers5[i + 1];
                    numbers5[i + 1] = temp;
                    flag = true;
                }
            }
        }
        System.out.println("Sorted array: " + Arrays.toString(numbers5));
    }
}

