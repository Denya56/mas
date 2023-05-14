package xor;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Expedition {
    private String location;

    private Set<Team> teamsParticipating = new HashSet<>();

    public Expedition(String location) {
        setLocation(location);
    }

    public String getLocation() {
        return location;
    }

    private void setLocation(String location) {
        if(location == null || location.isBlank()) {
            throw new IllegalArgumentException("Location has to be specified");
        }
        this.location = location;
    }

    public Set<Team> getTeamsParticipating() {
        return Collections.unmodifiableSet(teamsParticipating);
    }

    public void addTeam(Team team) {
        if(team == null) {
            throw new IllegalArgumentException("team has to be specified");
        }
        if(teamsParticipating.contains(team)) return;
        teamsParticipating.add(team);
        team.setExpedition(this);
    }

    public void removeTeam(Team team) {
        if(team == null) {
            throw new IllegalArgumentException("team has to be specified");
        }
        if(!teamsParticipating.contains(team)) return;
        teamsParticipating.remove(team);
        team.removeExpedition(this);
    }
}
