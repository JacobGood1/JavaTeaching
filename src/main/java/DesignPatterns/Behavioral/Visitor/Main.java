package DesignPatterns.Behavioral.Visitor;

public class Main {

    public static void main(String[] args) {
        Item a = new Message();
        Item b = new Activity();
        Visitor v = new ActionVisitor();
        b.accept(v);
    }
}
