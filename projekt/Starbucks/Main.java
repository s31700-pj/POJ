package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Drink drink;

        System.out.println("Wybierz napój:\n1. Kawa\n2. Herbata");
        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                drink = new Coffe();
                break;
            case "2":
                drink = new Tea();
                break;
            default:
                System.out.println("Nieprawidłowy wybór.");
                return;
        }

        drink.order();
    }
}