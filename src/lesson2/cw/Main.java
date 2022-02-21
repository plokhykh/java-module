package lesson2.cw;

import lesson2.cw.book.Comic;
import lesson2.cw.book.Magazine;
import lesson2.cw.musical_instruments.Drum;
import lesson2.cw.musical_instruments.Guitar;
import lesson2.cw.musical_instruments.Instrument;
import lesson2.cw.musical_instruments.Trumpet;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Instrument> instruments = new ArrayList<>();
        instruments.add(new Guitar(6));
        instruments.add(new Drum(1220));
        instruments.add(new Trumpet(5.2));

        for (Instrument i : instruments){
           i.play();
        }

        Magazine magazine = new Magazine(true, "ELLE", 30, true, 10);
        Comic comic = new Comic(true, "Batman", 15, true, 30);

        System.out.println(magazine);
        System.out.println(comic);

    }
}
