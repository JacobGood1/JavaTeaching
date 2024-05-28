package TicTacToe;

public class Square {
    private final int x;
    private final int y;
    private String representation = "-";
    
    public Square(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public int[] getLocation(){
        return new int[]{x, y};
    }
    
    public void makeX() {
        this.representation = "X";
    }
    public void makeAnything(String anything) {
        this.representation = anything;
    }
    public void makeO() {
        this.representation = "O";
    }
    public boolean isTaken() {
        return !this.representation.equals("-");
    }

    Square cloneMe(){
        var temp = new Square(this.x, this.y);
        temp.representation = this.representation;
        return temp;
    }

    @Override
    public String toString() {
        return this.representation;
    }
}
