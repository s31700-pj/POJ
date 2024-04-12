package org.example;
import lombok.*;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
public class Grupa {
    private String nazwa;
    private List<Uczeń> uczniowie;
    private List<Przedmiot> przedmioty;

    public Grupa(String nazwa) {
    }

    public void dodajUcznia(Uczeń uczeń) {
        uczniowie.add(uczeń);
    }

    public void dodajPrzedmiot(Przedmiot przedmiot) {
        przedmioty.add(przedmiot);
    }
}
