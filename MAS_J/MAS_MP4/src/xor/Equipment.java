package xor;

public class Equipment {
    private String name;

    private Team team;

    public Equipment(String name) {
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

    public Team getTeam() {
        return team;
    }

    public void assignToTeam(Team team) {
        if(team == null) {
            throw new IllegalArgumentException("team has to be specified");
        }
        if(this.team.equals(team)) return;
        this.team = team;
        team.addEquipment(this);
    }

    public void removeTeam(Team team) {
        if(team == null) {
            throw new IllegalArgumentException("team has to be specified");
        }
        if(!this.team.equals(team)) return;
        this.team = null;
        team.removeEquipment(this);
    }
}
