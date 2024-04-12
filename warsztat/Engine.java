package org.example;
import lombok.*;
@Getter
@Setter
@AllArgsConstructor
public class Engine{
    private String Model;
    private double Capacity;

    public String toString() {
        return "model silnika - " + Model + ", pojemność silnika - " + Capacity;
    }
}

