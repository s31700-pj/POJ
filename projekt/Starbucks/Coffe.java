package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Coffe implements Drink {
    private String size;
    private double price;
    private List<String> additions = new ArrayList<>();
    private double AdditionsPrice = 0;

    @Override
    public void order() {
        chooseSize();
        chooseAdditions();
        calculatePrice();
        saveOrder();
    }

    @Override
    public void chooseSize() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wybierz rozmiar:\nM - mała\nS - średnia\nD - duża");
        size = scanner.nextLine().toUpperCase();
        }

    @Override
    public void chooseAdditions() {
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wybierz dodatki:\n1. cukier - 1 zł\n2. mleko - 1,5 zł\n3. lód - 1 zł\n4. bita śmietana - 2 zł\n5. koniec");
        while (loop = true) {
            String additionName = scanner.nextLine();
            switch (additionName) {
                case "1":
                    additions.add("cukier");
                    AdditionsPrice += 1.0;
                    break;
                case "2":
                    additions.add("mleko");
                    AdditionsPrice += 1.5;
                    break;
                case "3":
                    additions.add("lód");
                    AdditionsPrice += 1.0;
                    break;
                case "4":
                    additions.add("bita śmietana");
                    AdditionsPrice += 2.0;
                    break;
                case "5":
                    loop = false;
                    return;
                default:
                    System.out.println("Nieprawidłowy dodatek. Wybierz numer znajdujący się przed nazwą dodatka.");
                    break;
            }
        }
    }

    @Override
    public void calculatePrice() {
        switch (size) {
            case "M":
                price = 10.0;
                break;
            case "S":
                price = 12.5;
                break;
            case "D":
                price = 15.0;
                break;
            default:
                System.out.println("Nieprawidłowy rozmiar. M - mała, S - średnia, D - duża.");
                return;
        }
        price += AdditionsPrice;
        System.out.println("Cena za kawę to " + price + " zł.");
    }

    private void saveOrder() {
        String filename = "Orders.txt";
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename, true))) {
                writer.println("Rodzaj napoju: Kawa");
                writer.println("Rozmiar: " + size);
                writer.println("Dodatki: " + additions);
                writer.println("Cena: " + price + " zł.");
                writer.println("*******************************************");
        } catch (IOException e) {
            System.out.println("Błąd podczas aktualizacji pliku 'Orders.txt': " + e.getMessage());
        }
    }
}
