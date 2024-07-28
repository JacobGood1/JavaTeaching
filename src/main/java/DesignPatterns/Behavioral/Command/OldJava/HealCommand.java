package DesignPatterns.Behavioral.Command.OldJava;

public class HealCommand implements Command{
    int healAmount;

    public HealCommand(int healAmount) {
        this.healAmount = healAmount;
    }
    @Override
    public void execute(Entity other) {
        System.out.println("Healing something...");
        other.setHealth(other.getHealth() + healAmount);    
    }
}
