package lesson2.hw;

import lesson2.hw.computers.Ultrabook;
import lesson2.hw.computers.Workstation;
import lesson2.hw.printable.Book;
import lesson2.hw.printable.Magazine;
import lesson2.hw.printable.Printable;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Ultrabook ultrabook = new Ultrabook(16, 245, true);
        ultrabook.turnOn();

        Workstation workstation = new Workstation(24, 240, true);
        workstation.turnOn();


        Book book = new Book("The Pillars of the Earth");
        book.print();

        Magazine magazine = new Magazine("ELLE");
        magazine.print();

        ArrayList<Printable> printables = new ArrayList<>();
        printables.add(book);
        printables.add(magazine);

        System.out.println(printables);
    }

}
