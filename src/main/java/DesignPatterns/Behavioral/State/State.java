package DesignPatterns.Behavioral.State;

public abstract class State {
    Entity entity;
    
    State(Entity entity){
        this.entity = entity;
    }
    abstract void run();
    void switchState(State state){
        entity.switchState(state);
    }; 
}
