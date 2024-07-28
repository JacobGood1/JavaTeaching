package DesignPatterns.Creational.Factory;

public class Human implements AttackingEntity {

    @Override
    public void attack() {
        System.out.println("Human pierces with a sword attack");
    }
}
