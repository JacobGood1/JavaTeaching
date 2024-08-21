package DesignPatterns.Behavioral.State;

public class PatrolState extends State{
    PatrolState(Entity entity) {
        super(entity);
    }

    int randomStateCode = 0;
    @Override
    void run() {
        randomStateCode++;
        switch (randomStateCode){
            case 1 -> System.out.println("goblin is approaching the sound");
            case 2 -> System.out.println("goblin sees something something");
            case 3 -> {
                System.out.println("ITS THE ENEMY TIME TO PURSUE");
                switchState(new PersueState(entity));
            }
        }
    }
}
