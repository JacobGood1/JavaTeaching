package TicTacToe;

import org.w3c.dom.html.HTMLBodyElement;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class AI {
    // just defines the function that selects a square
    @FunctionalInterface
    public interface SelectSquareFunction<Board, IntegerA, IntegerB, Square>
    {
        Square apply(Board b, IntegerA x, IntegerB y);
    }
    
    static public Square selectLocation(Board board, int x, int y) {
        try {
            return board.getSquare(x, y);
        } catch (Exception e) {
            return null;
        }
    }
    
    public static Square selectDown(Board board, int x, int y) {
        return AI.selectLocation(board,x, y + 1);
    }
    
    public static Square selectUpLeft(Board board, int x, int y) {
        return AI.selectLocation(board,x - 1, y - 1);
    }
    
    public static Square selectUpRight(Board board, int x, int y) {
        return AI.selectLocation(board,x + 1, y - 1);
    }
    
    public static Square selectDownLeft(Board board, int x, int y) {
        return AI.selectLocation(board,x - 1, y + 1);
    }
    
    public static Square selectDownRight(Board board, int x, int y) {
        return AI.selectLocation(board,x + 1, y + 1);
    }
    
    public static Square selectUp(Board board, int x, int y) {
        return AI.selectLocation(board,x, y - 1);
    }
    
    public static Square selectLeft(Board board, int x, int y) {
        return AI.selectLocation(board,x - 1, y);
    }
    
    public static Square selectRight(Board board, int x, int y) {
        return AI.selectLocation(board,x + 1, y);
    }
    final static List<SelectSquareFunction<Board, Integer, Integer, Square>> functions = List.of(
            AI::selectUp,
            AI::selectUpRight,
            AI::selectRight,
            AI::selectDownRight,
            AI::selectDown,
            AI::selectDownLeft,
            AI::selectLeft,
            AI::selectUpLeft
    );
    
    // lets make a board iteration for reusable iteration of the board instead of repeating code over and over
    public int minMax(Board board, boolean isXMove) {
        var score = board.winnerScore();
        int bestScore;
        Square currentSq;
        if (board.isGameOver(score)) {
            return score;
        }
        
        if(isXMove){
            bestScore = Integer.MIN_VALUE;
            // common occurrence show how to abstract this
            for (int y = 0; y < board.dimensions; y++) {
                for (int x = 0; x < board.dimensions; x++) {
                    currentSq = board.getSquare(x, y);
                    if (!currentSq.isTaken()) {
                        currentSq.makeX();
                        bestScore = Math.max(bestScore, minMax(board, !isXMove));
                        currentSq.makeAnything("-");
                    }    
                }
            }
        } else{
            bestScore = Integer.MAX_VALUE;
            for (int y = 0; y < board.dimensions; y++) {
                for (int x = 0; x < board.dimensions; x++) {
                    currentSq = board.getSquare(x, y);
                    if (!currentSq.isTaken()) {
                        currentSq.makeO();
                        bestScore = Math.min(bestScore, minMax(board, !isXMove));
                        currentSq.makeAnything("-");
                    }    
                }
            }
        }
        return bestScore;
    }
    // this does not include a depth score because im lazy
    public void makeBestMove(Board board) {
        var emptySquares = board.getEmptySquares(); // [sq1 sq3] -> [10 25]
        var scores = emptySquares.stream().map(s -> {
            var loc = s.getLocation();
            board.cloneBoard().placeLetter("X", loc[0], loc[1]);
            return minMax(board, false);
        }).toList();
        var maxScore = scores.stream().max(Integer::compareTo).get();
        var index = scores.indexOf(maxScore);
        var loc = emptySquares.get(index).getLocation();
        board.placeLetter("X", loc[0], loc[1]);
        
    }    
    
}
