package abstract_polymorphic;

public abstract class Company {
    private String name;
    private String address;

    public Company(String name, String address) {
        setName(name);
        setAddress(address);
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

    public String getAddress() {
        return address;
    }

    private void setAddress(String address) {
        if(address == null || address.isBlank())
        {
            throw new IllegalArgumentException("Address must be specified");
        }
        this.address = address;
    }
    public abstract double getDiscount();

    @Override
    public String toString() {
        return "Name: " + name + " Address: " + address + " Discount: " + getDiscount();
    }
}
