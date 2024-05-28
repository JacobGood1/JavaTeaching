package Teaching;

public interface Actions {
    default void speak(){
        System.out.println("I can speak");
    }
}
