package Teaching;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class FSM {
    // finite state machine
    State currentState = State.enter;
    int counter = 0;
    boolean isFinished = false;
    public void enter(){
        System.out.println("Entering state...");
        setState(State.exe);
    }
    public void exe(){
        if (counter < 3) {
            System.out.println("executing...");
            counter++;
        } else{
            setState(State.exit);
            System.out.println("Exiting state...");
        }
    }
    public void exit(){
        System.out.println("we have dun did exited");
        
    }
    
    public void setState(State state){
        currentState = state;
    }
    
    public void run(){
        switch (currentState){
            case enter -> enter();
            case exe -> exe();
            case exit -> exit();
        }
    }
    
    static boolean race(List<FSM> fsms){
        AtomicBoolean isRaceDone = new AtomicBoolean(false);
        fsms.forEach(fsm -> {
            fsm.run();
            if(fsm.isFinished){
                isRaceDone.set(true);
            }
        });
        return isRaceDone.get();
        
    }

    public static void main(String[] args) {
        FSM fsm = new FSM();
        var states = List.of(new FSM(), new FSM());
        states.forEach(s -> s.run());
        // skookumscript
        // race sync
        
        
    }
}
enum State{
    enter,
    exe,
    exit
}
