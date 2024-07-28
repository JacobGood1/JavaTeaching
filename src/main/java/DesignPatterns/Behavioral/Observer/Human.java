package DesignPatterns.Behavioral.Observer;

public class Human implements Observer {
    
    public void slap() {
        System.out.println("Human slaps dat");
    }

    @Override
    public void response() {
        slap();
    }
}
