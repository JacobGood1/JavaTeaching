package DesignPatterns.Behavioral.Command.OldJava;

public class AttackCommand implements Command {
    int str;

    public AttackCommand(int str) {
        this.str = str;
    }

    @Override
    public void execute(Entity other) {
        String otherEntName = other.getClass().getSimpleName();
        System.out.println("Attacking with " + str + " damage on " + otherEntName);
        other.setHealth(other.getHealth() - str);
        System.out.println(otherEntName + " now has health: " + other.getHealth());
    }
    
}
