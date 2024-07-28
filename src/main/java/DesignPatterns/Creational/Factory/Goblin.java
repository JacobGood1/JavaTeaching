package DesignPatterns.Creational.Factory;

public class Goblin implements AttackingEntity {
    @Override
    public void attack() {
        System.out.println("gobby slings mud!");    
    }
}
