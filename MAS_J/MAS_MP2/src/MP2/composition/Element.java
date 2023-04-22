package MP2.composition;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Element {
    private String name;
    private float length;
    private Furniture furniture;

    private static final Set<Element> extent = new HashSet<>();

    public Element(String name, float length, Furniture furniture) {
        setName(name);
        setLength(length);
        setFurniture(furniture);
        furniture.addElement(this);
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

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        if(length <= 0) {
            throw new IllegalArgumentException("Length cannot be 0 or smaller");
        }
        this.length = length;
    }

    public Furniture getFurniture() {
        return furniture;
    }

    public void setFurniture(Furniture furniture) {
        if(furniture == null) {
            throw new IllegalArgumentException("Furniture cannot be null");
        }
        this.furniture = furniture;
    }

    public static Set<Element> getExtent() {
        return Collections.unmodifiableSet(extent);
    }

    public static void delete(Element element) {
        if(element == null) {
            throw new IllegalArgumentException("Element cannot be null");
        }
        element.furniture.removeElement(element);
        extent.remove(element);
    }
}
