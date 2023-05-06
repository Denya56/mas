package multi_inheritance;

public class SkeletonArcher extends Skeleton implements ISkeletonArcher{
    private int numberOfArrows;

    public SkeletonArcher(String name, int numberOfArrows) {
        super(name);
        this.numberOfArrows = numberOfArrows;
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

    @Override
    public String toString() {
        return super.toString() + "\nNumber of arrows: " + numberOfArrows;
    }
}
