/*
PYT. 0:
Klasa abstrakcyjna może rozszerzać inną klasę abstrakcyjną lub nie abstrakcyjną, podczas
gdy interfejs może rozszerzać tylko interfejsy.
PYT. 1:
Przykładowy problem jaki może wystąpić to gdy zrobimy mu "plan zajęć". Grupy mogą mieć w
tym samym czasie różne zajęcia i nałożą się wtedy one na siebie (nie wiem czy dokładnie o to
chodziło w tym pytaniu, ale tak mi się wydaje)
PYT. 2:
zasada YAGNI, czyli you aren't gonna need it polega na tym, żeby dodawać rzeczy tylko wtedy,
kiedy je potrzebujemy a nie wtedy kiedy przewidujemy, że będziemy potrzebować.
zasada KISS, czyli keep it simple, stupid polega na tym aby utrzymać prostotę kodu i unikać
niepotrzebnych implementacji.
Myślę, że tutaj zwykły enum wystarczy. Sprawdzał się wcześniej to sprawdzi się i teraz :D
PYT. 3:
equals() sprawdza czy wartość dwóch obiektów jest równa. Jest używana gdy chcemy sprawdzić
równość (lub różność) obiektów pod względem wartości a nie referencji.
hashCode() sprawdza unikalny identyfikator liczbowy dwóch obiektów występujących w strukturach
danych.
Kontrakt między equals a hashCode to zależności które muszą między sobą wystąpić jeśli chce się
uniknąć błędów.
PYT DODATKOWE:
Jeśli te funkcje byłyby istotne dla działania programu lepiej byłoby użyć klasy abstrakcyjnej.
Można wtedy zrobić klase Sala z tymi funkcjami a potem abstrakcyjne klasy "komputerowa" i
"wykładowa".
Jeżeli jednak, tak jak w naszym przypadku są to mało istotne funkcje "urozmaicające" program i
do samej "uczelni" nie wnoszą nic wartościowego, to moim zdaniem użycie enuma dalej by wystarczyło
*/

package org.example;

public class Main {
    public static void main(String[] args) {

        Grupa grupa1 = new Grupa("grupa1");
        Grupa grupa2 = new Grupa("grupa2");
        Sala sala1 = new Sala(1,TypSali.komputerowa);
        Przedmiot informatyka = new Przedmiot("Informatyka",sala1);
        Uczeń uczeń1 = new Uczeń("Michał","Wysocki",31700);
        Uczeń uczeń2 = new Uczeń("Jan","Kowalski",69420);
        Uczeń uczeń3 = new Uczeń("Kamil","Ślimak",12345);
        Uczeń uczeń4 = new Uczeń("Piotr","Piotrowski",11111);
        Uczeń uczeń5 = new Uczeń("Jakub","Jakubowicz",22222);


        grupa1.dodajPrzedmiot(informatyka);
        grupa2.dodajPrzedmiot(informatyka);

        grupa1.dodajUcznia(uczeń1);
        grupa1.dodajUcznia(uczeń3);
        grupa1.dodajUcznia(uczeń5);
        grupa2.dodajUcznia(uczeń2);
        grupa2.dodajUcznia(uczeń4);
        grupa2.dodajUcznia(uczeń5);

    }
}