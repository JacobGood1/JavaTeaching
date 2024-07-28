package DesignPatterns.Behavioral.Command.NewJava;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Entity {
    int health;

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
    
    void doCommand(BiFunction<Entity, Integer, Entity> command, Entity entity, int arg) {
        command.apply(entity, arg);
    }
    
}
