package lesson2.hw.computers;

import java.util.Objects;

public class Ultrabook extends Laptop {

    private boolean isUltraBook;

    public Ultrabook() {
    }

    public Ultrabook(int RAM, int VRAM, boolean isUltraBook) {
        super(RAM, VRAM);
        this.isUltraBook = isUltraBook;
    }

    public boolean isUltraBook() {
        return isUltraBook;
    }

    public void setUltraBook(boolean ultraBook) {
        isUltraBook = ultraBook;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Ultrabook ultrabook = (Ultrabook) o;
        return isUltraBook == ultrabook.isUltraBook;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isUltraBook);
    }

    @Override
    public String toString() {
        return "Ultrabook{" +
                "isUltraBook=" + isUltraBook +
                '}';
    }

    public void turnOn() {
        System.out.println("UltraBook turn on");
    }

}
