package DesignPatterns.Behavioral.Strategy.OldJava;

import java.awt.color.ICC_ColorSpace;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        var humansList = IntStream.range(0, 10).mapToObj(_ -> new Human()).toList();
        var humans = new ArrayList<>(humansList);
        Collections.sort(humans, new StrengthComparator());
        humans.forEach(System.out::println);
//        Collections.sort(humans, new HealthComparator());
//        humans.forEach(System.out::println);
//        Collections.sort(humans, new DumberComparator());
//        humans.forEach(System.out::println);
    }
}
