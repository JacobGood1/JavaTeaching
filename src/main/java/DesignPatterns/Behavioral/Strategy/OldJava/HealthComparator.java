package DesignPatterns.Behavioral.Strategy.OldJava;

import java.util.Comparator;

public class HealthComparator implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return Integer.compare(o1.getHealth(), o2.getHealth());
    }
}
