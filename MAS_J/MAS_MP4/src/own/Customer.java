package own;

import java.time.LocalDate;

public class Customer {
    private String name;
    private LocalDate dateOfBirth;
    private double discount;

    public Customer(String name, LocalDate dateOfBirth, double discount) {
        setName(name);
        setDateOfBirth(dateOfBirth);
        setDiscount(discount);
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    private void setDateOfBirth(LocalDate dateOfBirth) {
        if(dateOfBirth == null) {
            throw new IllegalArgumentException("Date of birth has to be specified");
        }
        this.dateOfBirth = dateOfBirth;
    }

    private void setDiscount(double discount) {
        if(getAge() >= 18 && getAge() <= 65) this.discount = 0.2;
        else this.discount = discount;
    }

    private int getAge() {
        return LocalDate.now().getYear() - dateOfBirth.getYear();
    }
}
