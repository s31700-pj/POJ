package org.example;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class Car {

    private String model;
    private Engine engine;
    private Body body;
    private Wheels wheels;

public String toString() {
    return "Samochód: \nModel: " + model + "\nSilnik: " + engine + "\nKaroseria: " + body + "\nKoła: " + wheels;
}
}
