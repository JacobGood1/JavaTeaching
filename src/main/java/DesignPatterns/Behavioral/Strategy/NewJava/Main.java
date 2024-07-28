package DesignPatterns.Behavioral.Strategy.NewJava;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class Main {
    // no need to generate all of that heinous code
    public record Human(String name, int health, int str, int intel) { }
    static Human generateHuman(){
        return new Human(
            List.of("Jen", "Joe", "Jill", "Jenny", "Jeanette", "Mike", "Bob", "Bill", "IAMTIREDOFTHIS")
                    .get(ThreadLocalRandom.current().nextInt(0, 9)),   
            ThreadLocalRandom.current().nextInt(0, 100),
            ThreadLocalRandom.current().nextInt(0, 10),
            ThreadLocalRandom.current().nextInt(0, 10)
        );
    }
    public static void main(String[] args) {
        var humans = new ArrayList<>(IntStream.range(0, 10)
                                              .mapToObj(_ -> generateHuman())
                                              .toList());
        // we can implement any sorting strategy through lambdas no extra code needed
        humans.sort((h1, h2) -> Integer.compare(h1.str(), h2.str()) * -1); // comparing str
        humans.forEach(System.out::println);
        // another way to see strategy in action is with map
        IntStream.range(0, 10).map(i -> i + 1).forEach(System.out::println);
        // this is the strategy    ↑↑↑↑↑↑↑↑↑↑
        // we could change this lambda with any sort of computation changing the way map computes
                                  
    }
}
