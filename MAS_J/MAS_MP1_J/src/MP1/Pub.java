package MP1;

import java.io.*;
import java.util.*;

public class Pub implements Serializable{
    private static Set<Pub> extents = new HashSet<>();
    private static String FILENAME = "extent.txt";

    // Mandatory attr
    private String name;
    private String description;
    // Multi-value attr
    public Set<Beer> beerAvailable = new HashSet<>();
    // Complex attr
    private Address pubAddress;

    private String phoneNumber;
    private int budget;

    public Pub(String name, String description, Address address, String phoneNumber, int budget)
    {
        try
        {
            setName(name);
            setDescription(description);
            setPubAddress(address);
            setPhoneNumber(phoneNumber);
            setBudget(budget);
            extents.add(this);
        }
        catch (Exception e)
        {
            System.out.println("Error during creating new Pub");
        }

    }
    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
        return description;
    }

    public Address getPubAddress()
    {
        return pubAddress;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }
    public int GetBudget()
    {
        return budget;
    }

    public Set<Beer> getBeerAvailable()
    {
        return Collections.unmodifiableSet(beerAvailable);
    }

    // Derived attr
    public int getIncome()
    {
        return beerAvailable
                .stream()
                .mapToInt(a -> a.getPrice() * a.getAmountSold())
                .sum() - budget;
    }


    private void setName(String name)
    {
        if (name.isBlank() || name == null)
        {
            throw new IllegalArgumentException("Name should be specified");
        }
        else
            this.name = name;
    }

    private void setDescription(String desc)
    {
        if (desc.isBlank() || desc == null)
        {
            throw new IllegalArgumentException("Description should be specified");
        }
        else
            description = desc;
    }

    private void setPhoneNumber(String number)
    {
        if (number.isBlank() || number == null)
        {
            throw new IllegalArgumentException("Phone number should be specified");
        }
        else if(number.length() > 12)
        {
            throw new IllegalArgumentException("Phone number must not contain more than 12 characters");
        }
        else
            phoneNumber = number;
    }

    private void setPubAddress(Address address)
    {
        if (address == null)
        {
            throw new IllegalArgumentException("Address should be specified");
        }
        else
            pubAddress = address;
    }
    private void setBudget(int budget)
    {
        if(budget <= 0)
        {
            throw new IllegalArgumentException("Budget cannot be smaller than 0");
        }
        else
            this.budget = budget;
    }

    public void addBeerAvailable(Beer beer)
    {
        if (beer == null)
        {
            throw new IllegalArgumentException("Beer should be specified");
        }
        else
        {
            beerAvailable.add(beer);
        }
    }

    public void removeBeerAvailable(Beer beer)
    {
        if (beer == null)
        {
            throw new IllegalArgumentException("Beer should be specified");
        }
        else
        {
            if (beerAvailable.remove(beer))
                System.out.println("Removed " + beer + " from the sold list" );
            else
                System.out.println("No such beer in the list");
        }
    }

    public static Optional<Pub> findByName(String pubName){
        if(pubName == null ) {
            return Optional.empty();
        }
        return extents.stream().filter(x -> x.name.equals(pubName)).findAny();
    }

    @Override
    public String toString() {
        return name + " " + pubAddress + phoneNumber;
    }

    public static void writeExtents()
    {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(FILENAME))) {
            objectOutputStream.writeObject(extents);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadExtents()
    {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(FILENAME))) {
            extents = (Set<Pub>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Set<Pub> getExtents()
    {
        return Collections.unmodifiableSet(extents);
    }
}
