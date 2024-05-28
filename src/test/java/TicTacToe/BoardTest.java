package TicTacToe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void checkHorizontal() {
        var board = new Board(3);
        board.placeLetter("O", 2, 0);
        board.placeLetter("O", 1, 0);
        board.placeLetter("O", 0, 0);
        var result = board.checkHorizontal();
        assertEquals("O", result);
    }

    @Test
    void checkVertical() {
        var board = new Board(3);
        board.placeLetter("O", 0, 0);
        board.placeLetter("O", 0, 1);
        board.placeLetter("O", 0, 2);
        var result = board.checkVertical();
        assertEquals("O", result);
    }

    @Test
    void checkDiagonal() {
        // diagonal right
        var board = new Board(3);
        board.placeLetter("O", 0, 0);
        board.placeLetter("O", 1, 1);
        board.placeLetter("O", 2, 2);
        var result = board.checkDiagonal();
        assertEquals("O", result);
        
        // diagonal left
        board = new Board(3);
        board.placeLetter("X", 2, 0);
        board.placeLetter("X", 1, 1);
        board.placeLetter("X", 0, 2);
        result = board.checkDiagonal();
        assertEquals("X", result);
    }

    @Test
    void placeLetter() {
        var board = new Board(3);
        board.placeLetter("X", 0, 0);
        board.placeLetter("O", 2, 2);
        assertEquals("X", board.getSquare(0, 0).toString());
        assertEquals("O", board.getSquare(2, 2).toString());
    }

    @Test
    void cloneBoard() throws CloneNotSupportedException {
        var board = new Board(3);
        var clone = board.cloneBoard();
        clone.placeLetter("X", 0, 0);
        clone.placeLetter("O", 2, 2);
        assertEquals("X", clone.getSquare(0, 0).toString());
        assertEquals("O", clone.getSquare(2, 2).toString());
        assertEquals("-", board.getSquare(0, 0).toString());
        assertEquals("-", board.getSquare(2, 2).toString());
    }
}