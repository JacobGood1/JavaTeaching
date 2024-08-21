package DesignPatterns.Behavioral.State;

public class IdleState extends State{
    int idleTime = 0;

    IdleState(Entity entity) {
        super(entity);
    }

    @Override
    void run() {
        idleTime++;
        switch (idleTime) {
            case 1 -> System.out.println("Goblin is idle");
            case 2 -> System.out.println("Goblin is picking nose");
            case 3 -> System.out.println("Goblin is smoking some wacky gobacky");
            case 4 -> {
                System.out.println("Goblin hears a noise, instead of telling his friends he checks on the noise alone...");
                this.switchState(new PatrolState(entity));
            }
        }
    }
}
