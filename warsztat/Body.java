package org.example;
import lombok.*;
@Getter
@Setter
@AllArgsConstructor
public class Body{
    private Color color;

    public String toString() {
        return "kolor - " + color;
    }
}
