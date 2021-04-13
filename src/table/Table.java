package table;

import bean.Element;
import finder.NearElementsFinder;

import java.util.Collection;

public class Table {
    protected final int WIDTH;
    protected final int HEIGHT;

    protected Element[][] table;

    public Table(int width, final int height) {
        this.WIDTH = width;
        this.HEIGHT = height;

        init();
    }

    protected void init() {
        table = new Element[WIDTH][HEIGHT];
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                Element el = createNewElement(x, y);
                table[x][y] = el;
            }
        }
    }

    protected Element createNewElement(final int x, final int y) {
        return new Element(x, y);
    }

    public Collection<Element> getElementsNear(Element element) {
        return new NearElementsFinder(this).findElements(element);
    }

    public int getWidth() {
        return WIDTH;
    }

    public int getHeight() {
        return HEIGHT;
    }

    public Element[][] getTable() {
        return table;
    }
}
