package multi_inheritance;

public class Skeleton {
    private String name;

    public Skeleton(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if(name == null || name.isBlank())
        {
            throw new IllegalArgumentException("Name must be specified");
        }
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
