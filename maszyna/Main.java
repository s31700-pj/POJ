package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Maszyna maszyna = new Maszyna();
        maszyna.wyswietlProdukty();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Wybierz numer produktu z listy: ");
        int IDproduktu = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Wybierz metodę płatności (gotowka/karta): ");
        String metodaPlatnosci = scanner.nextLine();

        System.out.println("Wybierz walutę (zloty/euro/funt/dolar): ");
        String waluta = scanner.nextLine();

        maszyna.Platnosc(IDproduktu, metodaPlatnosci, waluta);
    }
}