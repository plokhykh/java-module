package lesson2.cw.book;

import java.util.Objects;

public class Papyrus {
    private boolean isHasCyperusPapyrus;

    public Papyrus() {
    }

    public Papyrus(boolean isHasCyperusPapyrus) {
        this.isHasCyperusPapyrus = isHasCyperusPapyrus;
    }

    public boolean isHasCyperusPapyrus() {
        return isHasCyperusPapyrus;
    }

    public void setHasCyperusPapyrus(boolean hasCyperusPapyrus) {
        isHasCyperusPapyrus = hasCyperusPapyrus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Papyrus papyrus = (Papyrus) o;
        return isHasCyperusPapyrus == papyrus.isHasCyperusPapyrus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isHasCyperusPapyrus);
    }

    @Override
    public String toString() {
        return "Papyrus{" +
                "isHasCyperusPapyrus=" + isHasCyperusPapyrus +
                '}';
    }
}
