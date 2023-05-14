package unique;

import java.util.HashSet;
import java.util.Set;

public class User {
    private String username;
    private static Set<String> allUsernames = new HashSet<>();

    public User(String username) {
        setUsername(username);
    }

    public String getUsername() {
        return username;
    }

    private void setUsername(String username) {
        if(allUsernames.contains(username)) {
            throw new IllegalArgumentException("Username has to be unique");
        }

        if(!username.equals(this.username) && this.username != null) {
            allUsernames.remove(this.username);
        }

        this.username = username;
        allUsernames.add(username);
    }
}
