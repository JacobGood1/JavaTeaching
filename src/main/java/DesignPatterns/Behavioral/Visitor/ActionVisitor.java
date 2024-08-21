package DesignPatterns.Behavioral.Visitor;

public class ActionVisitor implements Visitor {
    @Override
    public void visit(Activity a) {
        Dispatcher.export(a);
    }

    @Override
    public void visit(Message m) {
        Dispatcher.export(m);
    }
}
