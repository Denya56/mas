package subset;

import java.util.Set;

public class BasketballPlayer {
    private String name;

    private BasketballTeam team;

    public BasketballPlayer(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if(name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name has to be specified");
        }
        this.name = name;
    }

    public void addTeam(BasketballTeam team) {
        if(team == null) {
            throw new IllegalArgumentException("Player cannot be null");
        }
        if(this.team.equals(team)) return;
        this.team = team;
        team.addPlayer(this);
    }

    public void removeTeam(BasketballTeam team) {
        if(team == null) {
            throw new IllegalArgumentException("Player cannot be null");
        }
        if(!this.team.equals(team)) return;
        this.team = null;
        team.removePlayer(this);
    }

    public static void delete(BasketballPlayer player) {
        if(player == null) {
            throw new IllegalArgumentException("Player cannot be null");
        }
        player.team.removePlayer(player);
        player.team = null;
        //extent.remove(player);
    }
}
