package org.example;

import lombok.*;

@Getter
public enum Codes {
    HELLO(10.0),
    BIRTHDAY(15.0),
    REWARD(20.0),
    FAMILY(25.0);

    private final double discount;

    Codes(double discount) {
        this.discount = discount;
    }

    public static Codes matchingCode(String discount) {
        System.out.println("Sprawdzenie kodu zniżkowego: " + discount);
        for (Codes code : values()) {
            if (code.name().equalsIgnoreCase(discount)) {
                System.out.println("Pasujący kod: " + code.name() + ", zniżka: " + code.getDiscount());
                return code;
            }
        }
        throw new IllegalArgumentException("Nieprawidłowy kod zniżkowy");
    }
}
