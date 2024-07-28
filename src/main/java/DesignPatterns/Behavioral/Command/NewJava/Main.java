package DesignPatterns.Behavioral.Command.NewJava;

import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args) {
        BiFunction<Entity, Integer, Entity> attack = (e, damage) -> {
            e.setHealth(e.getHealth() - damage);
            return e;
        };
        BiFunction<Entity, Integer, Entity> heal = (e, healAmount) -> {
            e.setHealth(e.getHealth() + healAmount);
            return e;
        };

        Entity goblin = new Entity();
        Entity human = new Entity();
        // we can use method references or lambda expressions, either one is fine
        goblin.doCommand(Commands::attack, human, 10);
        human.doCommand(heal, human, 5);
        
    }
}
