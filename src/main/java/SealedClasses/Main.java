package SealedClasses;

public class Main {

    public static void main(String[] args) {
        // exhaustive pattern matching with switch
        Entities hum = new Human();
        switch(hum) {
            case Human h -> System.out.println("Human");
            case Goblin g -> System.out.println("Goblin");
        }
    }
}
