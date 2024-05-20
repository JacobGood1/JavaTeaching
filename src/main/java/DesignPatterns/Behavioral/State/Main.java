package DesignPatterns.Behavioral.State;

public class Main {
    public static void main(String[] args) {
        var gobby = new Goblin();

        for (int i = 0; i < 10; i++) {
            gobby.run();
        }
    }
}
