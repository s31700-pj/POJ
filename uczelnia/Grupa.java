package org.example;
import lombok.*;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
public class Grupa {
    private String nazwa;
    private List<Uczeń> uczniowie = new ArrayList<>();
    private List<Przedmiot> przedmioty = new ArrayList<>();

    public Grupa(@NonNull String nazwa) {
    }

    public void dodajUcznia(Uczeń uczeń) {
        uczniowie.add(uczeń);
    }

    public void dodajPrzedmiot(Przedmiot przedmiot) {
        przedmioty.add(przedmiot);
    }
}
