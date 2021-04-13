package bean;

import java.util.Objects;

public class Element {
    private final int x, y;

    public Element(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Element{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Element element = (Element) o;
        return x == element.x && y == element.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
