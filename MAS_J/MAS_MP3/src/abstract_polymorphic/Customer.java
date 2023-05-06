package abstract_polymorphic;

public class Customer extends Company {
    private static double MAX_DISCOUNT = 0.2;
    private int yearsOfBeingCustomer;

    public Customer(String name, String address, int yearsOfBeingCustomer) {
        super(name, address);
        setYearsOfBeingCustomer(yearsOfBeingCustomer);
    }

    public int getYearsOfBeingCustomer() {
        return yearsOfBeingCustomer;
    }

    private void setYearsOfBeingCustomer(int yearsOfBeingCustomer) {
        if(yearsOfBeingCustomer < 0)
        {
            throw new IllegalArgumentException("Years of being customer cannot be smaller than 0");
        }
        this.yearsOfBeingCustomer = yearsOfBeingCustomer;
    }

    @Override
    public double getDiscount() {
        return Math.min(yearsOfBeingCustomer * 0.04, MAX_DISCOUNT);
    }
}
