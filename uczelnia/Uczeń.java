package org.example;
import lombok.*;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
public class Uczeń {
    private String Imię;
    private String Nazwisko;
    private int nrStudenta;
    private List<Grupa> grupy;

    public Uczeń(String Imię, String Nazwisko, int nrStudenta) {
    }

    }
}
