package DesignPatterns.Behavioral.Visitor;

public class Dispatcher {
    public static void export(Item i) {
        System.out.println("an item of great relevance");
    }
    public static void export(Message m) {
        System.out.println("a message of great importance");
    }
}
// explore ecs for multiple dispatch
