package DesignPatterns.Behavioral.Strategy.OldJava;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Human {
    private String name;
    private int health, str, intel;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStr() {
        return str;
    }

    public void setStr(int str) {
        this.str = str;
    }

    public int getIntel() {
        return intel;
    }

    public void setIntel(int intel) {
        this.intel = intel;
    }
    
    public Human() {
        this.health = ThreadLocalRandom.current().nextInt(50, 100 + 1);
        this.str = ThreadLocalRandom.current().nextInt(2, 10 + 1);;
        this.intel = ThreadLocalRandom.current().nextInt(2, 10 + 1);;
        var names = List.of("Jen", "Joe", "Jill", "Jenny", "Jeanette", "Mike", "Bob", "Bill", "IAMTIREDOFTHIS");
        this.name = names.get(ThreadLocalRandom.current().nextInt(0, names.size() - 1));
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", str=" + str +
                ", intelligence=" + intel +
                '}';
    }
}
