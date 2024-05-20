package DesignPatterns.Behavioral.State;

public class Entity { 
    public State state = new IdleState(this);
    void switchState(State state){
        this.state = state; 
    }
    void run(){
        state.run();
    }
}
