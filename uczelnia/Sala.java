package org.example;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class Sala {
    private int nr;
    private TypSali typ;
    private boolean prądWłączony;
    private boolean czysta;

    public Sala(@NonNull int nr, @NonNull TypSali typ) {

    }

    public void wyczyscSale() {
        czysta = true;
    }

    public void włączPrąd() {
        prądWłączony = true;
    }

    public void wyłączPrąd() {
        prądWłączony = false;
    }
}
