package ModernJava;

public class PatternMatching {
    record Goblin(int x, int y) {}

    public static void main(String[] args) {
        var gobby = new Goblin(1,2);
        if(gobby instanceof Goblin(int x, int y)) {
            System.out.println(y + x);
        }
        var gobby2 = new Goblin(5,2);
        switch (gobby2) {
            case Goblin(int x, int y) when x > 5 -> System.out.println(x);
            case Goblin(int x, int y) when x == 5 -> System.out.println(x);
            case Goblin g when g.x == 9000 -> System.out.println(g.x);
            default -> System.out.println("default");
        }
    }
}
