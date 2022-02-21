package lesson2.cw.musical_instruments;

import java.util.Objects;

public class Trumpet implements Instrument {
    private double diameter;

    public Trumpet() {
    }

    public Trumpet(double diameter) {
        this.diameter = diameter;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trumpet trumpet = (Trumpet) o;
        return diameter == trumpet.diameter;
    }

    @Override
    public int hashCode() {
        return Objects.hash(diameter);
    }

    @Override
    public String toString() {
        return "Trumpet{" +
                "diameter=" + diameter +
                '}';
    }

    @Override
    public void play() {
        System.out.println("play - Trumpet. It has " + diameter + " diameter");
    }
}
