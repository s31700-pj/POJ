package org.example;

public class Service implements Reduce {

    @Override
    public double applyDiscount(String discount) {
        System.out.println("Otrzymany kod zniżkowy w Service to - " + discount);
        Codes code = Codes.matchingCode(discount);
        System.out.println("Pasujący kod zniżkowy: " + code.name());
        double discountValue = code.getDiscount();
        System.out.println("Wartość zniżki: " + discountValue);
        return code.getDiscount();

    }
}
