package TicTacToe;

public class Square {
    
    boolean isTaken = false;
    private Square up;
    private Square down;
    private Square left;
    private Square right;
    private Square upLeft;
    private Square upRight;
    private Square downLeft;
    private Square downRight;
    
    public Square getUpLeft() {
        return upLeft;
    }
    
    public Square getUpRight() {
        return upRight;
    }
    
    public Square getDownLeft() {
        return downLeft;
    }
    
    public Square getDownRight() {
        return downRight;
    }
    
    public Square getUp() {
        return up;
    }
    
    public Square getDown() {
        return down;
    }
    
    public Square getLeft() {
        return left;
    }
    
    public Square getRight() {
        return right;
    }
    
    public boolean isTaken() {
        return isTaken;
    }
    public void setSquareNeighbors(int location,int dimensions, Board board) {
        dimensions = (int)Math.sqrt(dimensions);
        int xOffSet = location % dimensions;
        int yOffSet = location / dimensions;
        int yLoc = dimensions; ;
        
        if (xOffSet == 0) {
            left = null;
            right = board.get(location + 1);
        } else if (xOffSet == dimensions - 1) {
            left = board.get(location - 1);
            right = null;
        } else {
            left = board.get(location - 1);
            right = board.get(location + 1);
        }
        if (yOffSet == 0) {
            up = null;
            down = board.get(location + yLoc);
        } else if (yOffSet == dimensions - 1) {
            up = board.get(location - yLoc);
            down = null;
        } else {
            up = board.get(location - yLoc);
            down = board.get(location + yLoc);
        }
        if (up != null && left != null) {
            upLeft = board.get(location - yLoc - 1);
        }
        if (up != null && right != null) {
            upRight = board.get(location - yLoc + 1);
        }
        if (down != null && left != null) {
            downLeft = board.get(location + yLoc - 1);
        }
        if (down != null && right != null) {
            downRight = board.get(location + yLoc + 1);
        }
    }
    public static Square makeSquare(String letter) {
        if (letter.equals("X")) {
            return new X();
        } else if (letter.equals("O")) {
            return new O();
        } 
        return new Blank();
    }
}

class X extends Square {
    
    X(){
        this.isTaken = true;
    }
    @Override
    public String toString() {
        return "X";
    }
}

class O extends Square {
    O(){
        this.isTaken = true;
    }
    @Override
    public String toString() {
        return "Y";
    }
}

class Blank extends Square {
    @Override
    public String toString() {
        return "-";
    }
}
