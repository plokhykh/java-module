package lesson2.hw.computers;

import java.util.Objects;

public abstract class Laptop extends PC {
    private int RAM;
    private int VRAM;

    public Laptop() {
    }

    public Laptop(int RAM, int VRAM) {
        this.RAM = RAM;
        this.VRAM = VRAM;
    }

    public int getRAM() {
        return RAM;
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }

    public int getVRAM() {
        return VRAM;
    }

    public void setVRAM(int VRAM) {
        this.VRAM = VRAM;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Laptop laptop = (Laptop) o;
        return RAM == laptop.RAM && VRAM == laptop.VRAM;
    }

    @Override
    public int hashCode() {
        return Objects.hash(RAM, VRAM);
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "RAM=" + RAM +
                ", VRAM=" + VRAM +
                '}';
    }

    public abstract void turnOn ();
}
