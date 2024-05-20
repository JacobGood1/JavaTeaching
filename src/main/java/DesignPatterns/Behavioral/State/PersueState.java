package DesignPatterns.Behavioral.State;

public class PersueState extends State{
    PersueState(Entity entity) {
        super(entity);
    }

    @Override
    void run() {
        System.out.println("Goblin is running after enemy forever!!!");
    }
}
