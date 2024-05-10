package org.example;
import lombok.*;
import java.util.*;
@Getter
@Setter
@AllArgsConstructor
public class Maszyna {
    private List<Produkt> produkty;
    private double zloty = 1;
    private double euro = 4.5;
    private double funt = 5.0;
    private double dolar = 4.0;
    private double wrzuconaKwota;

    public Maszyna() {
        produkty = new ArrayList<>();
        produkty.add(new Produkt(1,"Batonik",2.5));
        produkty.add(new Produkt(2,"Herbatniki",1.5));
        produkty.add(new Produkt(3,"Krakersy",1));
        produkty.add(new Produkt(4,"Chipsy",6));
        produkty.add(new Produkt(5,"Żelki",4.5));
        produkty.add(new Produkt(6,"Cukierki",4));
        produkty.add(new Produkt(7,"Guma do żucia",2.5));
        produkty.add(new Produkt(8,"Woda",2));
        produkty.add(new Produkt(9,"Pepsi",5));
        produkty.add(new Produkt(10,"Energetyk",6.5));
    }
    
    public void wyswietlProdukty() {
        System.out.println("Produkty w automacie: ");
        for (Produkt produkt : produkty) {
            System.out.println(produkt.getId() + ". " + produkt.getNazwa() + " - " + produkt.getCena() + " zł");
        }
    }

    private Produkt IDwybranegoProduktu(int IDproduktu) {
        for (Produkt produkt : produkty) {
            if (produkt.getId() == IDproduktu) {
                return produkt;
            }
        }
        return null;
    }

    public void Platnosc(int IDproduktu, String metodaPlatnosci, String waluta) {
        Produkt wybranyProdukt = IDwybranegoProduktu(IDproduktu);

        if (wybranyProdukt == null) {
            System.out.println("Automat nie posiada produktu o takim numerze");
            return;
        }

        double cena;
        double kurs;
        String nazwaWaluty;

        switch (waluta) {
            case "zloty":
                kurs = zloty;
                nazwaWaluty = "zł";
                break;
            case "euro":
                kurs = euro;
                nazwaWaluty = "euro";
                break;
            case "funt":
                kurs = funt;
                nazwaWaluty = "funt";
                break;
            case "dolar":
                kurs = dolar;
                nazwaWaluty = "dolar";
                break;
            default:
                System.out.println("Nieprawidłowa waluta");
                return;
        }

        cena = wybranyProdukt.cenaPoZmianeWaluty(kurs);
        System.out.println("Wybrany produkt: " + wybranyProdukt.getNazwa());
        System.out.println("Cena: " + cena + " " + nazwaWaluty);

        if(metodaPlatnosci.equals("gotowka")) {
            platnoscGotowka(wybranyProdukt, kurs, nazwaWaluty);
        } else if (metodaPlatnosci.equals("karta")) {
            platnoscKarta(wybranyProdukt, nazwaWaluty, kurs);
        } else {
            System.out.println("Nieprawidłowa metoda płatności.");
        }
    }
    private boolean czyPlatnoscPrzeszla(double platnosc) {
        double[] akceptowalneKwoty = {0.5, 1, 2, 5, 10};
        for (double kwota : akceptowalneKwoty) {
            if (platnosc == kwota) {
                return true;
            }
        }
        return false;
    }
    private void platnoscGotowka(Produkt produkt, double kurs, String nazwaWaluty) {
        Scanner scanner = new Scanner(System.in);
        double pozostalaKwota = produkt.cenaPoZmianeWaluty(kurs);

        while (pozostalaKwota > 0) {
            System.out.println("Wrzuć monetę 0.5 " + nazwaWaluty + ", 1 " + nazwaWaluty + ", 2 " + nazwaWaluty + ", 5 " + nazwaWaluty + ", lub banknot 10 " + nazwaWaluty);
            double platnosc = scanner.nextDouble();
            if (czyPlatnoscPrzeszla(platnosc)) {
                wrzuconaKwota += platnosc;
                pozostalaKwota -= platnosc;
                if (pozostalaKwota > 0) {
                    System.out.println("Do zapłaty pozostało " + pozostalaKwota + " " + nazwaWaluty);
                }
            } else {
                System.out.println("Nieprawidłowa moneta lub banknot.");
            }
        }

        double reszta = wrzuconaKwota - produkt.cenaPoZmianeWaluty(kurs);
        if (reszta > 0) {
            System.out.println("Reszta: " + reszta + " " + nazwaWaluty);
        } else if (reszta == 0) {
            System.out.println("Produkt został wydany.");
        }
    }

    private void platnoscKarta(Produkt produkt, String nazwaWaluty, double kurs) {
        System.out.println("Z konta zostało pobrane " + produkt.getCena() / kurs + " " + nazwaWaluty);
    }
}
