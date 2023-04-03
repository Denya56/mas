package MP1;

import java.io.Serializable;

public class Address implements Serializable {
    private String streetName;
    private String buildingNumber;
    // Optional attr
    private String apartmentNumber;

    public Address(String streetName, String buildingNumber)
    {
        SetStreetName(streetName);
        SetBuildingNumber(buildingNumber);
    }

    public Address(String streetName, String buildingNumber, String apartmentNumber)
    {
        SetStreetName(streetName);
        SetBuildingNumber(buildingNumber);
        SetApartmentNumber(apartmentNumber);
    }

    public String GetStreetName()
    {
        return streetName;
    }
    public String GetBuildingNumber()
    {
        return buildingNumber;
    }
    public String GetApartmentNumber()
    {
        return apartmentNumber;
    }

    private void SetStreetName(String name)
    {

        if(name.isBlank() || name == null) {
            throw new IllegalArgumentException("Street name cannot be empty");
        }
        else {
            streetName = name;
        }
    }
    private void SetBuildingNumber(String numb)
    {
        if (numb.isBlank() || numb == null)
        {
            throw new IllegalArgumentException("Building number cannot be empty");
        } else if(!isNumeric(numb))
        {
            throw new IllegalArgumentException("Building number is not integer");
        }
        else {
            buildingNumber = numb;
        }
    }
    private void SetApartmentNumber(String numb)
    {
        if (numb.isBlank())
        {
            throw new IllegalArgumentException("Building number cannot be empty");
        }
        else {
            apartmentNumber = numb;
        }

    }

    @Override
    public String toString() {
        return streetName + " " + buildingNumber + " " + apartmentNumber + " ";
    }

    private boolean isNumeric(String num)
    {
        try {
            Integer.parseInt(num);
            return true;
        }
        catch( NumberFormatException e ) {
            return false;
        }
    }
}
