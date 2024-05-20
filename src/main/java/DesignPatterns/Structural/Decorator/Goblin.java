package DesignPatterns.Structural.Decorator;

import java.util.Arrays;
import java.util.function.Function;

public class Goblin {
    Function<String, String> punch; 
    public static String soggyPunch(String s) {
        return s + ", Soggy Punch";
    }

    public static String foggyPunch(String s) {
        return s + ", Foggy Punch";
    }
    static String noodlyPunch(String s) {
        return s + ", Noodly Punch";
    }
    
    String punch () {
        return this.punch.apply("Goblin is punching");
    }
    
    public Goblin(Function<String, String>... punches) {
        this.punch = 
                Arrays.stream(punches)
                      .reduce(Function::andThen)
                      .get();
    }

    public static void main(String[] args) {
        var gobby = new Goblin(Goblin::foggyPunch, Goblin::soggyPunch, Goblin::noodlyPunch, Goblin::soggyPunch);
        System.out.println(
            gobby.punch()
                
        );
    }

    
}
