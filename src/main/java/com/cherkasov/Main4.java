package com.cherkasov;

import java.util.Scanner;

import java.sql.SQLOutput;

public class Main4 {
    public static void main(String[] args) {
        // Task 1 //
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write your string:  ");
        String line = scanner.nextLine();
        if (line.length() >= 1) {
            System.out.println("The first character is: " + line.charAt(0));
            System.out.println("The last character is: " + line.charAt(line.length() - 1));
        } else {
            System.out.println("Your string is null!");
        }

        // Task 2 //
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Write your string: ");
        String line2 = scanner.nextLine();
        if (line.length() >= 1) {
            System.out.println("Does this phrase: \"" + line2 + "\", ends with \"se\"?");
            System.out.println(line2.endsWith("se"));
        } else {
            System.out.println("Your string is null!");
        }
        // Task 3 //
        String String3 = "Stephen Edwin King";
        Scanner scanner3 = new Scanner(System.in);
        System.out.println("Write your string: ");
        String line3 = scanner3.nextLine();
        if (line3.length() >= 1) {
            System.out.println("Does this phrase: \"" + String3 + "\", contain this phrase: \"" + line3 + "\"?");
            System.out.println(String3.contains(line3));
        } else {
            System.out.println("Your string is null!");
        }
        // Task 4 //
        String String4 = "Stephen Edwin King";
        Scanner scanner4 = new Scanner(System.in);
        System.out.println("Write your string: ");
        String line4 = scanner4.nextLine();
        if (line4.length() >= 1) {
            System.out.println("Does this phrase: \"" + String4 + "\", contain this phrase: \"" + line4 + "\"?");
            System.out.println(String4
                    .toUpperCase()
                    .contains(line4.toUpperCase()));
        } else {
            System.out.println("Your string is null!");
        }
        // Task 5 //
        Scanner scanner5 = new Scanner(System.in);
        System.out.println("Write your string: ");
        String line5 = scanner.nextLine();
        if (line.length() >= 1) {
            System.out.println("Does this phrase: \"" + line5 + "\", start with \"Red\"?");
            System.out.println(line5.startsWith("Red"));
        } else {
            System.out.println("Your string is null!");
        }

    }
}
