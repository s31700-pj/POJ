package org.example;
import lombok.*;
@Getter
@Setter
@AllArgsConstructor
public class Wheels {
    private int Vmax;

    public String toString() {
        return "prędkość maksymalna - " + Vmax + " km/h";
    }
}
