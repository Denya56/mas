import abstract_polymorphic.Company;
import abstract_polymorphic.Customer;
import abstract_polymorphic.Supplier;
import dynamic.BasketballPlayer;
import dynamic.BasketballPlayerType;
import multi_inheritance.HybrydSkeleton;
import multi_inheritance.Skeleton;
import multi_inheritance.SkeletonArcher;
import multi_inheritance.SkeletonSwordsman;
import overlapping.Player;
import overlapping.PlayerType;

import java.util.EnumSet;

public class Main {
    public static void main(String[] args) {
        System.out.println("=====Abstract_polymorphic=====");
        Company c1 = new Customer("cust", "address", 3);
        Company c2 = new Customer("cust2", "address2", 7);

        Company s1 = new Supplier("sup", "address", 0.15);

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(s1);
        System.out.println();

        System.out.println("=====Overlapping=====");
        try {
            Player p1 = new Player("Aaron", 10, 50.0, EnumSet.of(PlayerType.FIGHTER), 100.0, null, null);
            Player p2 = new Player("Gandalf", 14, 35.0, EnumSet.of(PlayerType.RANGER, PlayerType.MAGE), null, 75.0, 50.0);
            System.out.println(p1.getName() + " " + p1.getLevel() + " lvl HP: " + p1.getHitPoints() + " " + p1.getPlayerType() + "\nStrength: " +
                    p1.getStrength());
            System.out.println();
            System.out.println(p2.getName() + " " + p2.getLevel() + " lvl HP: " + p2.getHitPoints() + " " + p2.getPlayerType() + "\nAgility: " +
                    p2.getAgility() + "\nWisdom: " + p2.getWisdom());

            System.out.println();
            System.out.println(p1.getName() + " slashed with " + p1.getSlashWithSwordDamage(30.0) + " damage!");
            System.out.println(p2.getName()  + " shot with " + p2.shootWithBow(20.0, true) + " damage!");
            System.out.println(p2.drinkPotion("Health potion"));
        } catch (Exception e) {

        }
        System.out.println();
        System.out.println("=====Dynamic=====");
        BasketballPlayer bp1 = new BasketballPlayer("Teppei", BasketballPlayerType.INSIDE, 1.5, null);
        BasketballPlayer bp2 = new BasketballPlayer("Hyuuga", BasketballPlayerType.OUTSIDE, null, 2.5);
        System.out.println(bp1);
        System.out.println(bp2);
        bp1.changeToOutside(2.0);
        bp2.changeToInside(1.3);
        System.out.println();
        System.out.println(bp1);
        System.out.println(bp2);
        System.out.println();
        System.out.println("=====Multi-inheritance=====");
        Skeleton skeleton1 = new SkeletonSwordsman("Bone1", "Steel");
        Skeleton skeleton2 = new SkeletonArcher("Bone2", 100);
        Skeleton skeleton3 = new HybrydSkeleton("Hybrid bone", "Obsidian", 200, 50.0);

        System.out.println(skeleton1);
        System.out.println("=====");
        System.out.println(skeleton2);
        System.out.println("=====");
        System.out.println(skeleton3);
        System.out.println("=====");

        System.out.println();

        System.out.println("=====Multi-aspect Inheritance=====");
    }
}
