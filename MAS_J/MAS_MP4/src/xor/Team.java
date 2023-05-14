package xor;

import subset.BasketballPlayer;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Team {
    private String name;

    private Set<Equipment> equipmentAssigned = new HashSet<>();
    private Expedition expedition;

    public Team(String name) {
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

    public Set<Equipment> getEquipmentAssigned() {
        return Collections.unmodifiableSet(equipmentAssigned);
    }

    public Expedition getExpedition() {
        return expedition;
    }

    public void addEquipment(Equipment equipment) {
        if(this.expedition != null) {
            throw new IllegalArgumentException("Cannot add equipment when there's expedition pending");
        }
        if(equipment == null) {
            throw new IllegalArgumentException("Equipment cannot be null");
        }
        if(equipmentAssigned.contains(equipment)) return;
        equipmentAssigned.add(equipment);
        equipment.assignToTeam(this);
    }

    public void setExpedition(Expedition expedition) {
        if(!this.equipmentAssigned.isEmpty()) {
            throw new IllegalArgumentException("Cannot set expedition when there's equipment assigned");
        }
        if(expedition == null) {
            throw new IllegalArgumentException("Expedition cannot be null");
        }
        if(this.expedition.equals(expedition)) return;
        this.expedition = expedition;
        expedition.addTeam(this);
    }

    public void removeEquipment(Equipment equipment) {
        if(equipment == null) {
            throw new IllegalArgumentException("Equipment cannot be null");
        }
        if(!equipmentAssigned.contains(equipment)) return;
        equipmentAssigned.remove(equipment);
        equipment.removeTeam(this);
    }

    public void removeExpedition(Expedition expedition) {
        if(expedition == null) {
            throw new IllegalArgumentException("Expedition cannot be null");
        }
        if(!this.expedition.equals(expedition)) return;
        this.expedition = null;
        expedition.removeTeam(this);
    }

    public static void delete(Team team) {
        if(team == null) {
            throw new IllegalArgumentException("Player cannot be null");
        }
        team.expedition.removeTeam(team);
        team.expedition = null;
        Set<Equipment> tempEquipment = Set.copyOf(team.equipmentAssigned);
        team.equipmentAssigned.clear();

        tempEquipment.forEach(x -> x.removeTeam(team));
        //extent.remove(player);
    }
}
