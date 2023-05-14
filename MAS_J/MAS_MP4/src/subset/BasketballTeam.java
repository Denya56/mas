package subset;

import java.util.HashSet;
import java.util.Set;

public class BasketballTeam {
    private String name;

    private Set<BasketballPlayer> allPlayers = new HashSet<>();

    private Set<BasketballPlayer> startingLayout = new HashSet<>();

    public BasketballTeam(String name) {
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

    public Set<BasketballPlayer> getAllPlayers() {
        return allPlayers;
    }

    public void addPlayer(BasketballPlayer player) {
        if(player == null) {
            throw new IllegalArgumentException("Player cannot be null");
        }
        if(allPlayers.contains(player)) return;
        allPlayers.add(player);
        player.addTeam(this);
    }

    public void addPlayerToStartingLayout(BasketballPlayer player) {
        if(player == null) {
            throw new IllegalArgumentException("Player cannot be null");
        }
        if(!allPlayers.contains(player)) {
            throw new IllegalArgumentException("Player must be in allPlayers to be added as starting layout");
        }
        startingLayout.add(player);
    }

    public void removePlayer(BasketballPlayer player) {
        if(player == null) {
            throw new IllegalArgumentException("Player cannot be null");
        }
        startingLayout.remove(player);
        if(allPlayers.contains(player)) return;
        allPlayers.remove(player);
        player.removeTeam(this);
    }


    public Set<BasketballPlayer> getStartingLayout() {
        return startingLayout;
    }

    public static void delete(BasketballTeam team) {
        if(team == null) {
            throw new IllegalArgumentException("Employee cannot be null");
        }
        Set<BasketballPlayer> tempPlayers = Set.copyOf(team.allPlayers);
        team.allPlayers.clear();

        tempPlayers.forEach(x -> x.removeTeam(team));
        //extent.remove(player);
    }
}
