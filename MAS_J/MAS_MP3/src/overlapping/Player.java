package overlapping;

import java.util.EnumSet;

public class Player implements IFighter, IRanger, IMage{
    private String name;
    private int level;
    private double maxHitPoints;
    private EnumSet<PlayerType> playerType;
    private Double strength;
    private Double agility;
    private Double wisdom;

    public Player(String name, int level, double hitPoints, EnumSet<PlayerType> playerType, Double strength, Double agility, Double wisdom) {
        setPlayerType(playerType);
        setName(name);
        setLevel(level);
        setHitPoints(hitPoints);
        if(playerType.contains(PlayerType.FIGHTER)) setStrength(strength);
        if(playerType.contains(PlayerType.RANGER)) setAgility(agility);
        if(playerType.contains(PlayerType.MAGE)) setWisdom(wisdom);
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

    public int getLevel() {
        return level;
    }

    private void setLevel(int level) {
        if(level <= 0)
        {
            throw new IllegalArgumentException("Level cannot be smaller than 1");
        }
        this.level = level;
    }

    public double getHitPoints() {
        return maxHitPoints;
    }

    private void setHitPoints(double maxHitPoints) {
        if(maxHitPoints <= 0)
        {
            throw new IllegalArgumentException("Max hit points cannot be smaller than 1");
        }
        this.maxHitPoints = maxHitPoints;
    }

    public EnumSet<PlayerType> getPlayerType() {
        return playerType;
    }

    private void setPlayerType(EnumSet<PlayerType> playerType) {
        if(playerType == null) {
            throw new IllegalArgumentException("Player type cannot be null");
        }
        if(playerType.isEmpty()) {
            throw new IllegalArgumentException("Player has to have at least one type");
        }
        this.playerType = EnumSet.copyOf(playerType);
    }

    public Double getStrength() {
        return strength;
    }

    public void setStrength(Double strength) {
        if(strength == null) return;
        if(strength <= 0) {
            throw new IllegalArgumentException("Strength cannot be smaller than 1");
        }
        this.strength = strength;
    }

    public Double getAgility() {
        return agility;
    }

    public void setAgility(Double agility) {
        if(agility == null) return;
        if(agility <= 0)
        {
            throw new IllegalArgumentException("Agility cannot be smaller than 1");
        }
        this.agility = agility;
    }

    public Double getWisdom() {
        return wisdom;
    }

    public void setWisdom(Double wisdom) {
        if(wisdom == null) return;
        if(wisdom <= 0)
        {
            throw new IllegalArgumentException("Wisdom cannot be smaller than 1");
        }
        this.wisdom = wisdom;
    }

    @Override
    public double getSlashWithSwordDamage(double swordWeight) throws Exception {
        if(playerType.contains(PlayerType.FIGHTER))
            return strength / swordWeight * 0.8;
        else {
            throw new Exception("Player is not a fighter");
        }
    }

    @Override
    public String drinkPotion(String potionName) throws Exception {
        if(playerType.contains(PlayerType.MAGE))
            return name + " drank " + potionName + "!";
        else {
            throw new Exception("Player is not a mage");
        }
    }

    @Override
    public double shootWithBow(double windSpeed, boolean isCompanionWind) throws Exception {
        if(playerType.contains(PlayerType.RANGER))
            return agility * (windSpeed * (isCompanionWind ? 1 : 0) / 100);
        else {
            throw new Exception("Player is not a ranger");
        }
    }
}
