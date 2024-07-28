package DesignPatterns.Behavioral.Observer;

public class Main {
    int inc(int x){
        return x + 1;
    }
    public static void main(String[] args) {
        Goblin gobby = new Goblin();
        Human human = new Human();
        human.subscribe();
        Observer.update();
    }
}
