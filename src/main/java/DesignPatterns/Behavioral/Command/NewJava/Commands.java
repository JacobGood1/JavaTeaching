package DesignPatterns.Behavioral.Command.NewJava;



public interface Commands {
    static Entity attack(Entity other, int damage) {
        other.setHealth(other.getHealth() - damage);
        return other;
    }
    
}
