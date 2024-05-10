package org.example;
import lombok.*;
@Getter
@Setter
@AllArgsConstructor
public class Produkt {
    private int id;
    private String nazwa;
    private double cena;

    public double cenaPoZmianeWaluty(double kurs) {
        return cena / kurs;
    }

}
