package lesson2.cw.book;

import java.util.Objects;

public class Comic extends Book {
    private int countImages;

    public Comic() {
    }

    public Comic(boolean isHasCyperusPapyrus, String name, int countPages, boolean isHasCover, int countImages) {
        super(isHasCyperusPapyrus, name, countPages, isHasCover);
        this.countImages = countImages;
    }

    public int getCountImages() {
        return countImages;
    }

    public void setCountImages(int countImages) {
        this.countImages = countImages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comic comic = (Comic) o;
        return countImages == comic.countImages;
    }

    @Override
    public int hashCode() {
        return Objects.hash(countImages);
    }

    @Override
    public String toString() {
        return "Comic{" +
                "countImages=" + countImages +
                '}';
    }
}
