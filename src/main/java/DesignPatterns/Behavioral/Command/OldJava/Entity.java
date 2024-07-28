package DesignPatterns.Behavioral.Command.OldJava;

public class Entity {
    int health;
    Command command;
    
    public int getHealth(){
        return health;
    }
    
    public void setHealth(int health){
        this.health = health;
    }
    
    public void setCommand(Command command){
        this.command = command;
    }
    
    public void executeCommand(Entity entity){
        command.execute(entity);
    }
}
