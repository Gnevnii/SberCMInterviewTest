import bean.Element;

import java.util.Collection;

public class Main {

    public static void main(String[] args) {
        Table table = new Table(9, 9);
        Collection<Element> elements = table.getElementsNear(new Element(0, 8));
        elements.forEach(System.out::println);

        System.out.println("========");
        Table greedyTable = new GreedyTable(9, 9);
        Collection<Element> elementsGreedy = greedyTable.getElementsNear(new Element(0, 8));
        elementsGreedy.forEach(System.out::println);
    }
}
