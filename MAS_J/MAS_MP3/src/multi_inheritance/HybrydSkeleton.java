package multi_inheritance;

public class HybrydSkeleton extends SkeletonSwordsman implements ISkeletonArcher {
    private int numberOfArrows;
    private double maxCarryWeight;

    public HybrydSkeleton(String name, String swordMaterial, int numberOfArrows, double maxCarryWeight) {
        super(name, swordMaterial);
        this.numberOfArrows = numberOfArrows;
        this.maxCarryWeight = maxCarryWeight;
    }

    @Override
    public int getNumberOfArrows() {
        return numberOfArrows;
    }

    @Override
    public void setNumberOfArrows(int numberOfArrows) {
        if(numberOfArrows < 0)
        {
            throw new IllegalArgumentException("Number of arrows cannot be less than 0");
        }
        this.numberOfArrows = numberOfArrows;
    }

    public double getMaxCarryWeight() {
        return maxCarryWeight;
    }

    public void setMaxCarryWeight(double maxCarryWeight) {
        if(maxCarryWeight < 0)
        {
            throw new IllegalArgumentException("Max carry weight cannot be less than 0");
        }
        this.maxCarryWeight = maxCarryWeight;
    }

    @Override
    public String toString() {
        return super.toString()
        + "\nNumber of arrows: " + numberOfArrows + "\nMax carry weight: " + maxCarryWeight;
    }
}
