package multi_inheritance;

public class SkeletonSwordsman extends  Skeleton {
    private String swordMaterial;

    public SkeletonSwordsman(String name, String swordMaterial) {
        super(name);
        setSwordMaterial(swordMaterial);
    }

    public String getSwordMaterial() {
        return swordMaterial;
    }

    public void setSwordMaterial(String swordMaterial) {
        if(swordMaterial == null || swordMaterial.isBlank())
        {
            throw new IllegalArgumentException("Sword material must be specified");
        }
        this.swordMaterial = swordMaterial;
    }

    @Override
    public String toString() {
        return super.toString() + "\nSword material: " + swordMaterial;
    }
}
