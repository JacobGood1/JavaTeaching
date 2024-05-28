package TicTacToe;

import java.lang.reflect.AccessFlag;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Board {
    int dimensions;
    ArrayList<ArrayList<Square>> board = new ArrayList<>();
    public Board(int dimensions) {
        this.dimensions = dimensions;
        IntStream.range(0, this.dimensions).forEach(y -> {
            var tempBoard = new ArrayList<Square>();
            IntStream.range(0, this.dimensions).forEach(x -> {
                tempBoard.add(new Square(x,y));
            });
            board.add(tempBoard);
        });
    }
    public void displayBoard() {
        board.forEach(System.out::println);
    }
    String checkHorizontal(){
        for (var row : board) {
            var winner = new Winner(dimensions);
            for (var s : row) {
                winner.updateSquareCount(s.toString());
            }
            if (winner.isThereAWinner()){
                return winner.whoIsWinner();
            }
        }
        return "-";
    }
    String checkVertical(){
        for (int c = 0; c < dimensions; c++) {
            var winner = new Winner(dimensions);
            for (int r = 0; r < dimensions; r++) {
                winner.updateSquareCount(board.get(r).get(c).toString());
            }
            if (winner.isThereAWinner()){
                return winner.whoIsWinner();
            }
        }
        return "-";
    }
    
    String checkDiagonal(){
        var winner = new Winner(dimensions);
        for (int i = 0; i < dimensions; i++) {
            winner.updateSquareCount(board.get(i).get(i).toString());
        }
        if (winner.isThereAWinner()){
            return winner.whoIsWinner();
        }
        winner = new Winner(dimensions);
        for (int x = dimensions - 1, y = 0; x >= 0 && y < dimensions; x--, y++) {
            winner.updateSquareCount(board.get(y).get(x).toString());
        }
        if (winner.isThereAWinner()){
            return winner.whoIsWinner();
        }
        return "-";
    }
    void placeLetter(String letter, int x, int y){
        var square = board.get(y).get(x);
        if(letter.equals("X")) {
            square.makeX();
        }
        else {
            square.makeO();
        }
    }
    Square getSquare(int x, int y){
        return board.get(y).get(x);
    }

    Board cloneBoard() {
        var newBoard = new Board(this.dimensions);
        for (int i = 0; i < dimensions; i++) {
            var temp = new ArrayList<Square>();
            for (var s: board.get(i)) {
                temp.add(s.cloneMe());
            }
            newBoard.board.set(i, temp);
        }
        return newBoard; 
        
    }
    public int winnerScore(){
        var scoreDist = Map.of("X", 1, "O", -1, "-", 0);
        return
        Stream.of(checkHorizontal(),checkVertical(), checkDiagonal())
              .reduce(0, (acc,next) -> {
                  if(acc != 0){
                      return acc;
                  } else {
                      return scoreDist.get(next);
                  }
              }, (left, right) -> left);
        
    }
    public boolean isBoardFull(){
        var isFull = true;
        for (var row : board) {
            for (var s : row) {
                if(!s.isTaken()){
                    isFull = false;
                }
            }
        }
        return isFull;
    }
    public boolean isGameOver(int winnerScore){
        return isBoardFull() || winnerScore != 0;
    }
    
    public  List<Square> getEmptySquares(){
        var emptySquares = new ArrayList<Square>();
        for (var row : board) {
            for (var s : row) {
                if(!s.isTaken()){
                    emptySquares.add(s);
                }
            }
        }
        return emptySquares;
    }
}
