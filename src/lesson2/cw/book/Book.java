package lesson2.cw.book;

import java.util.Objects;

public class Book extends Papyrus{
    private String name;
    private int countPages;
    private boolean isHasCover;


    public Book() {
    }

    public Book(boolean isHasCyperusPapyrus, String name, int countPages, boolean isHasCover) {
        super(isHasCyperusPapyrus);
        this.name = name;
        this.countPages = countPages;
        this.isHasCover = isHasCover;
    }

    public int getCountPages() {
        return countPages;
    }

    public void setCountPages(int countPages) {
        this.countPages = countPages;
    }

    public boolean isHasCover() {
        return isHasCover;
    }

    public void setHasCover(boolean hasCover) {
        isHasCover = hasCover;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Book book = (Book) o;
        return countPages == book.countPages && isHasCover == book.isHasCover;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), countPages, isHasCover);
    }

    @Override
    public String toString() {
        return "Book{" +
                "countPages=" + countPages +
                ", isHasCover=" + isHasCover +
                '}';
    }
}
