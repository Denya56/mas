package attribute;

public class Player {
    private String name;
    private int level;

    public Player(String name, int level) {
        setName(name);
        setLevel(level);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if(name == null || name.isBlank())
        {
            throw new IllegalArgumentException("Name must be specified");
        }
        if(name.length() > 20) {
            throw new IllegalArgumentException("Name cannot be longer than 20 characters");
        }
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    private void setLevel(int level) {
        if(level <= 0)
        {
            throw new IllegalArgumentException("Level cannot be less than 1");
        }
        if(this.level >= level) {
            throw new IllegalArgumentException("Cannot set level equal or smaller than current one");
        }
        this.level = level;
    }
}
