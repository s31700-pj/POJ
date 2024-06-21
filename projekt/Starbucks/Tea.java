package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tea implements Drink {
    private String size;
    private double price;
    private List<String> additions = new ArrayList<>();
    private double AdditionsPrice;
    private String discount;
    private boolean applyDiscount = false;
    @Override
    public void order() {
        chooseSize();
        chooseAdditions();
        discount();
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
        System.out.println("Wybierz dodatki:\n1. cukier - 1 zł\n2. sok - 1,5 zł\n3. miód - 2 zł\n4. cytryna - 1,5 zł\n5. koniec");
        while (loop = true) {
            String additionName = scanner.nextLine();
            switch (additionName) {
                case "1":
                    additions.add("cukier");
                    AdditionsPrice += 1.0;
                    break;
                case "2":
                    additions.add("sok");
                    AdditionsPrice += 1.5;
                    break;
                case "3":
                    additions.add("miód");
                    AdditionsPrice += 2;
                    break;
                case "4":
                    additions.add("cytryna");
                    AdditionsPrice += 1.5;
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

    public void discount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Czy posiadasz kod zniżkowy?\n1. Tak\n2. Nie");
        String loop = scanner.nextLine();
        switch(loop) {
            case "1":
                System.out.println("Podaj kod zniżkowy:");
                discount = scanner.nextLine().toUpperCase();
                applyDiscount = true;
                System.out.println("Kod zniżkowy to: " + discount);
                break;
            case "2":
                applyDiscount = false;
                break;
            default:
                System.out.println("Nieprawidłowy wybór.");
                applyDiscount = false;
                break;
        }
    }

    @Override
    public void calculatePrice() {
        System.out.println(applyDiscount);
        switch (size) {
            case "M":
                price = 5.0;
                break;
            case "S":
                price = 6.5;
                break;
            case "D":
                price = 8.0;
                break;
            default:
                System.out.println("Nieprawidłowy rozmiar. M - mała, S - średnia, D - duża.");
                return;
        }
        price += AdditionsPrice;

        if (applyDiscount) {
            Service discountService = new Service();
            try {
                System.out.println("Przekazany kod zniżkowy: " + discount);
                double discountPercentage = discountService.applyDiscount(discount);
                System.out.println("Otrzymana zniżka to " + discountPercentage + "%");
                double discountAmmount = (discountPercentage / 100) * price;
                price -= discountAmmount;
                System.out.println("Zastosowano zniżkę w wysokości " + discountPercentage + "%");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Cena za herbatę to " + price + " zł.");
    }
    private void saveOrder() {
        String filename = "Orders.txt";
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename, true))) {
            writer.println("Rodzaj napoju: Herbata");
            writer.println("Rozmiar: " + size);
            writer.println("Dodatki: " + additions);
            writer.println("Zastosowany kod zniżkowy: " + discount);
            writer.println("Cena: " + price + " zł.");
            writer.println("*******************************************");
        } catch (IOException e) {
            System.out.println("Błąd podczas aktualizacji pliku 'Orders.txt': " + e.getMessage());
        }
    }
}
