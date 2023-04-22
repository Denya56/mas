package MP2.composition;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Furniture {
    private String name;

    private static final Set<Furniture> extent = new HashSet<>();

    private final Set<Element> elements = new HashSet<>();

    public Furniture(String name) {
        setName(name);
        extent.add(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name has to be specified");
        }
        this.name = name;
    }

    public Set<Element> getElements() {
        return Collections.unmodifiableSet(elements);
    }

    public static Set<Furniture> getExtent() {
        return Collections.unmodifiableSet(extent);
    }

    public void checkElement(Element element) {
        if(element == null) {
            throw new IllegalArgumentException("Element cannot be null");
        }
        if(element.getName() == null || element.getName().isBlank()) {
            throw new IllegalArgumentException("Element name cannot be null or empty");
        }
    }

    public void addElement(Element element) {
        checkElement(element);
        if(elements.contains(element)) {
            throw new IllegalArgumentException("Furniture already has this element");
        }
        elements.add(element);
    }

    public void removeElement(Element element) {
        checkElement(element);
        if(!elements.contains(element)) return;

        elements.remove(element);
        Element.delete(element);
    }

    public static void delete(Furniture furniture) {
        if(furniture == null) {
            throw new IllegalArgumentException("Furniture cannot be null");
        }
        Set<Element> tempElements = Set.copyOf(furniture.elements);
        furniture.elements.clear();
        tempElements.forEach(Element::delete);
        extent.remove(furniture);
    }
}
