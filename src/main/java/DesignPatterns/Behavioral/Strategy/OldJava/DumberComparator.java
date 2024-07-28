package DesignPatterns.Behavioral.Strategy.OldJava;

import java.util.Comparator;

public class DumberComparator implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return Integer.compare(o1.getIntel(), o2.getIntel());
    }
}
