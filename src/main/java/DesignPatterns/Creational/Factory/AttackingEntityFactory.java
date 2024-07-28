package DesignPatterns.Creational.Factory;

public class AttackingEntityFactory {

    public static AttackingEntity create(AttackingEntities type) {
        return switch (type) {
            case Human -> new Human();
            case Goblin -> new Goblin();
        };
    }
}
