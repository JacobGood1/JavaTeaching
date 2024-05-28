package Teaching;

public class Goblin extends Humanoid implements Actions{
    private int x,y;

    public void setX(int x) {
        if (x > 10){
            
        }
        System.out.println("Goblin was changed!!!!!!!");
        this.x = x + 1;
    }

    public Goblin(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Goblin{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
    @Override
    public void slap(){
        System.out.println("Gobby slaps!");
    }
    public void slap(int x){
        System.out.println("Gobby slaps for damage: " + x);
    }

    public static void main(String[] args) {
        Goblin goblin = new Goblin(0,0);
        goblin.slap();
        goblin.slap(10);
        Human human = new Human();
        human.slap();
    }
}
