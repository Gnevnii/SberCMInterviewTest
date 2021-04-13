import bean.Element;
import bean.GreedyElement;

import java.util.Collection;

public class GreedyTable extends Table {

    public GreedyTable(final int width, final int height) {
        super(width, height);
    }

    @Override
    protected void init() {
        super.init();
        updateGreedyElements();
    }

    private void updateGreedyElements() {
        NearElementsFinder nearElementsFinder = new NearElementsFinder(this);
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                GreedyElement el = (GreedyElement) table[x][y];
                el.setConnectedElements(nearElementsFinder.findElements(el));
            }
        }
    }

    @Override
    public Collection<Element> getElementsNear(Element element) {
        if (isOutOfBound(element)) {
            throw new IllegalArgumentException();
        }

        return ((GreedyElement) table[element.getX()][element.getY()]).getConnectedElements();
    }

    @Override
    protected Element createNewElement(final int x, final int y) {
        return new GreedyElement(x, y);
    }

    private boolean isOutOfBound(Element element) {
        return element.getX() < 0 || element.getX() >= WIDTH || element.getY() < 0 || element.getY() >= HEIGHT;
    }
}
