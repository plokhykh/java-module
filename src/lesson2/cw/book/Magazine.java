package lesson2.cw.book;

import java.util.Objects;

public class Magazine extends Book {
    private int countArticles;

    public Magazine() {
    }

    public Magazine(boolean isHasCyperusPapyrus, String name, int countPages, boolean isHasCover, int countArticles) {
        super(isHasCyperusPapyrus, name, countPages, isHasCover);
        this.countArticles = countArticles;
    }

    public int getCountArticles() {
        return countArticles;
    }

    public void setCountArticles(int countArticles) {
        this.countArticles = countArticles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Magazine magazine = (Magazine) o;
        return countArticles == magazine.countArticles;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), countArticles);
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "countArticles=" + countArticles +
                '}';
    }
}
