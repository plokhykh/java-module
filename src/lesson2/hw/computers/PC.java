package lesson2.hw.computers;

import java.util.Objects;

public abstract class PC {
    private String CPU;

    public PC() {
    }

    public PC(String CPU) {
        this.CPU = CPU;
    }

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PC pc = (PC) o;
        return Objects.equals(CPU, pc.CPU);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CPU);
    }

    @Override
    public String toString() {
        return "PC{" +
                "CPU='" + CPU + '\'' +
                '}';
    }

}
