package com.cherkasov;

public class Main {
    public static void main(String[] args) {
        System.out.println( "Denys Cherkasov");
        for (int y = 5, i = 0; i <= 10; i++, y += 2) {
            System.out.println("Крок " +i + ", значення " + y);
        }
        for (int i = 0; i <= 10; i++) {
            if (i == 3) {
                continue;
            }
            if (i == 6) {
                break;
            }
            System.out.println(i);
        }
    }
}
