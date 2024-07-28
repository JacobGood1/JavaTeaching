package DesignPatterns.Creational.Factory;

public class Main {
    public static void main(String[] args) {
        AttackingEntityFactory.create(AttackingEntities.Goblin);
        AttackingEntityFactory.create(AttackingEntities.Human);
    }
}
