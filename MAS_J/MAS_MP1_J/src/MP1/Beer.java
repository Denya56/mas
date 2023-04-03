package MP1;

import java.io.Serializable;

public class Beer implements Serializable {
    private String name;
    private int price;
    private int amountSold;
    // Class attr
    private static int MAX_PRICE = 1000;

    public Beer(String name, int price, int amountSold)
    {
        setName(name);
        setPrice(price);
        setAmountSold(amountSold);
    }

    public int getAmountSold() {
        return amountSold;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void setAmountSold(int amount) {
        if(amount < 0) {
            throw new IllegalArgumentException("Amount cannot be less than zero");
        }
        else {
            this.amountSold = amount;
        }
    }

    public void setPrice(int price) {
        if(price < 0) {
            throw new IllegalArgumentException("Price cannot be smaller than zero");
        } else if(price > MAX_PRICE) {
            throw new IllegalArgumentException("Price cannot be higher than maximum amount");
        }
        else {
            this.price = price;
        }
    }

    public void setName(String name) {
        if(name.isBlank() || name == null) {
            throw new IllegalArgumentException("Beer name cannot be empty");
        }
        else {
            this.name = name;
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
