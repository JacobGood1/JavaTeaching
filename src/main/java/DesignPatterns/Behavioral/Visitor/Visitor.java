package DesignPatterns.Behavioral.Visitor;

public interface Visitor {
    void visit(Activity a);
    void visit(Message m);
}

