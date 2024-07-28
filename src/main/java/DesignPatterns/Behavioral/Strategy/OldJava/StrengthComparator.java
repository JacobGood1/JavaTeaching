package DesignPatterns.Behavioral.Strategy.OldJava;

import java.util.Comparator;

public class StrengthComparator implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return Integer.compare(o1.getStr(), o2.getStr()) * -1;
    }
}
