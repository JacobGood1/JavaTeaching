package DesignPatterns.Behavioral.Visitor;

public abstract class Item {
    abstract void accept(Visitor v);
}

class Message extends Item {
    @Override
    void accept(Visitor v) {
        v.visit(this);
    }
}

class Activity extends Item {
    @Override
    void accept(Visitor v) {
        v.visit(this);
    }
}