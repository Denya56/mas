package MP1;

public class Main {
    public static void main(String[] args) {
        Pub p1 = new Pub("Name", "desc", new Address("street", "34"), "1232131", 100);
        Pub p2 = new Pub("Name2", "desc2", new Address("street2", "2", "1"), "1232131", 1000);

        System.out.println("Class extent");
        for (Pub pub : Pub.getExtents()) {
            System.out.println(pub);
        }
        System.out.println();

        System.out.println("Persistence");
        Pub.writeExtents();
        Pub.loadExtents();
        for (Pub pub : Pub.getExtents()) {
            System.out.println(pub);
        }
        System.out.println();

        System.out.println("Complex attribute | Optional attribute");
        try {
            Address a1 = new Address("", "");

        } catch (IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }
        System.out.println();

        try {
            Address a2 = new Address("asdas", "1");
            Address a3 = new Address("asdas", "2", "12");
            System.out.println(a2);
            System.out.println(a3);

        } catch (IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }
        System.out.println();

        System.out.println("Mandatory attribute");
        try {
            Pub p3 = new Pub("", "desc", new Address("street", "34"), "1232131", 10);
        } catch (IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }
        System.out.println();

        System.out.println("Derived attribute");
        try {
            Pub p3 = new Pub("Name", "desc", new Address("street", "34"), "1232131", 10);
            p3.addBeerAvailable(new Beer("as", 12, 1));
            System.out.println(p3.getIncome());

        } catch (IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }
        System.out.println();


        System.out.println("Multi-value attribute");
        try{
            Beer b3 = new Beer("", 123, -11);
        } catch (IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }

        try {
            Pub p4 = new Pub("Name", "desc", new Address("street", "34"), "1232131", 100);
            Beer b1 = new Beer("as", 123, 1);
            Beer b2 = new Beer("as2", 123, 1);

            p4.addBeerAvailable(b1);
            p4.addBeerAvailable(b2);
            for (Beer beer : p4.getBeerAvailable())
            {
                System.out.println(beer);
            }
            p4.removeBeerAvailable(b1);
        } catch (IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }
        System.out.println();

        System.out.println("Class attribute");
        try {
            Beer b4 = new Beer("asss", 9999, 1);
        } catch (IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }
        System.out.println();

        System.out.println("Class method");
        System.out.println(Pub.findByName("Name"));

    }
}
