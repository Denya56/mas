package abstract_polymorphic;

public class Supplier extends Company {
    private double discountFactor;

    public Supplier(String name, String address, double discountFactor) {
        super(name, address);
        setDiscountFactor(discountFactor);
    }

    public double getDiscountFactor() {
        return discountFactor;
    }

    private void setDiscountFactor(double discountFactor) {
        if(discountFactor <= 0)
        {
            throw new IllegalArgumentException("Discount factor cannot be 0 or smaller");
        }
        this.discountFactor = discountFactor;
    }

    @Override
    public double getDiscount() {
        return discountFactor;
    }
}
