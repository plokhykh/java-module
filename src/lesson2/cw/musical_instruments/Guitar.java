package lesson2.cw.musical_instruments;

import java.util.Objects;

public class Guitar implements Instrument {
    private int stings;

    public Guitar() {
    }

    public Guitar(int stings) {
        this.stings = stings;
    }

    public int getStings() {
        return stings;
    }

    public void setStings(int stings) {
        this.stings = stings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Guitar guitar = (Guitar) o;
        return stings == guitar.stings;
    }

    @Override
    public int hashCode() {
        return Objects.hash(stings);
    }

    @Override
    public String toString() {
        return "Guitar{" +
                "stings=" + stings +
                '}';
    }

    @Override
    public void play() {
        System.out.println("play - Guitar. It has " + stings + " stings");
    }
}
