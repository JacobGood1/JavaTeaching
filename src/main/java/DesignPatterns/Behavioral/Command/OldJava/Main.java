package DesignPatterns.Behavioral.Command.OldJava;

public class Main {
    public static void main(String[] args) {
        Entity goblin = new Entity();
        Entity human = new Entity();
        goblin.setCommand(new AttackCommand(10));
        goblin.executeCommand(human);
    }
}
