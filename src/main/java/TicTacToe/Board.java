package TicTacToe;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class Board {
    int dimensions;
    ArrayList<Square> board = new ArrayList<>();
    private Board(int dimensions) {
        this.dimensions = dimensions * dimensions;
        IntStream.range(0, this.dimensions).forEach(i -> board.add(Square.makeSquare("blank")));
        
    }
    private Board setSquareNeighbors() {
        IntStream.range(0, dimensions).forEach(i -> board.get(i).setSquareNeighbors(i, dimensions, this));
        return this;
    }
    public Square get(int i){
        return board.get(i);
    }

    
    public void displayBoard() {
        for (int i = 0; i < Math.sqrt(dimensions); i++) {
            for (int j = 0; j < Math.sqrt(dimensions); j++) {
                System.out.print(board.get(i + j));
            }
            System.out.println();   
        }
    }

    public static Board makeBoard(int dimensions) {
        return new Board(dimensions).setSquareNeighbors();
    }
}
