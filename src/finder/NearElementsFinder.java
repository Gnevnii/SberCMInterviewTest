package finder;

import bean.Element;
import table.Table;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


public class NearElementsFinder implements ElementsFinder {
    private final Table table;

    public NearElementsFinder(Table table) {
        this.table = table;
    }

    @Override
    public Collection<Element> findElements(final Element element) {
        if (isOutOfBound(element)) {
            throw new IllegalArgumentException();
        }

        Set<Element> result = new HashSet<>();
        addNullSafe(result, getUpperElement(element));
        addNullSafe(result, getUpperRightElement(element));
        addNullSafe(result, getRightElement(element));
        addNullSafe(result, getBottomRightElement(element));
        addNullSafe(result, getBottomElement(element));
        addNullSafe(result, getBottomLeftElement(element));
        addNullSafe(result, getLeftElement(element));
        addNullSafe(result, getUpperLeftElement(element));
        return result;
    }

    private void addNullSafe(final Set<Element> result, final Element element) {
        if (element != null) result.add(element);
    }

    private Element getUpperElement(Element element) {
        return getElement(element.getX(), element.getY() - 1);
    }

    private Element getUpperRightElement(Element element) {
        return getElement(element.getX() + 1, element.getY() - 1);
    }

    private Element getRightElement(Element element) {
        return getElement(element.getX() + 1, element.getY());
    }

    private Element getBottomRightElement(Element element) {
        return getElement(element.getX() + 1, element.getY() + 1);
    }

    private Element getBottomElement(Element element) {
        return getElement(element.getX(), element.getY() + 1);
    }

    private Element getBottomLeftElement(Element element) {
        return getElement(element.getX() - 1, element.getY() + 1);
    }

    private Element getLeftElement(Element element) {
        return getElement(element.getX() - 1, element.getY());
    }

    private Element getUpperLeftElement(Element element) {
        return getElement(element.getX() - 1, element.getY() - 1);
    }

    private Element getElement(final int x0, final int y0) {
        if (isOutOfBound(x0, y0)) {
            return null;
        } else {
            return table.getTable()[x0][y0];
        }
    }

    private boolean isOutOfBound(Element element) {
        return isOutOfBound(element.getX(), element.getY());
    }

    private boolean isOutOfBound(int x, int y) {
        return x < 0 || x >= table.getWidth() || y < 0 || y >= table.getTable()[0].length;
    }
}
