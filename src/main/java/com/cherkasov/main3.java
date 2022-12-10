package com.cherkasov;

public class main3 {
    public static void main(String[] args) {
        double a = Math.random() * 100;
        double b = Math.random() * 100;
        double c = Math.random() * 100;
        double p;
        double square;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
        if ((a + b) > c && (a + c) > b && (b + c) > a) {
            p = (a + b + c) / 2;
            square = Math.sqrt(p * (p - a) * (p - b) * (p - c));
            System.out.println("The square = " + square);
        } else {
            System.out.println('0');
        }

        int number1 = (int) ( Math.random() * 200 - 100 );
        int number2 = (int) ( Math.random() * 200 - 100 );
        int number3 = (int) ( Math.random() * 200 - 100 );
        System.out.println("Number 1 = " + number1);
        System.out.println("Number 2 = " + number2);
        System.out.println("Number 3 = " + number3);
        int minNumber = number1 <= number2 ? number1 : number2;
        minNumber = minNumber <= number3 ? minNumber : number3;
        System.out.println("Minimum number = " + minNumber);

        int number = (int) (Math.random()*(200+1)) - 100;
        String pairedOrUnpaired = number % 2 == 0 ? "парне число" : "не парне число";
        System.out.println(number + ": " + pairedOrUnpaired);

        int d = (int) (Math.random() * 100000);
        System.out.println("Число з 10 системи числення: " + d);
        StringBuilder builder = new StringBuilder();
        while (d != 0) {
            builder.append(d % 2);
            d /= 2;
        } builder.reverse();
        System.out.println("Число з двійкової системи числення: " + builder);
    }
}
