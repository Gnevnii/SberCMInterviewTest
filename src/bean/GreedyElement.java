package bean;

import java.util.Collection;

public class GreedyElement extends Element {
    private Collection<Element> connectedElements;

    public GreedyElement(final int x, final int y) {
        super(x, y);
    }

    public Collection<Element> getConnectedElements() {
        return connectedElements;
    }

    public void setConnectedElements(final Collection<Element> connectedElements) {
        this.connectedElements = connectedElements;
    }
}
