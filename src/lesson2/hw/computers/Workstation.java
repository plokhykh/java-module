package lesson2.hw.computers;

import java.util.Objects;

public class Workstation extends Laptop{
    private boolean isWorkstation;

    public Workstation() {
    }

    public Workstation(int RAM, int VRAM, boolean isWorkstation) {
        super(RAM, VRAM);
        this.isWorkstation = isWorkstation;
    }

    public boolean isWorkstation() {
        return isWorkstation;
    }

    public void setWorkstation(boolean workstation) {
        isWorkstation = workstation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Workstation that = (Workstation) o;
        return isWorkstation == that.isWorkstation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isWorkstation);
    }

    @Override
    public String toString() {
        return "Workstation{" +
                "isWorkstation=" + isWorkstation +
                '}';
    }

    public void turnOn(){
        System.out.println("Workstation turn on");
    }
}
