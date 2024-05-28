package TicTacToe;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

class AITest {
    static Board board = new Board(3);
    static Board board2 = new Board(3);
    static int x = 1;
    static int y = 1;
    // before
    @BeforeAll
    static void setUpBeforeClass() {
        board.placeLetter("X", x, y);
        board2.placeLetter("X", 0, 0);
    }
    
    @Test
    void outOfBounds() {
        var square = AI.selectLocation(board2, -1, 0);
        assertEquals(null, square);
        square = AI.selectLocation(board2, 0, -1);
        assertEquals(null, square);
        square = AI.selectLocation(board2, 3, 0);
        assertEquals(null, square);
        square = AI.selectLocation(board2, 0, 3);
        assertEquals(null, square);
        
        AI.selectLocation(board2, 0,0).makeX();

        // valid directions
        var currentSquare = AI.selectRight(board2,0,0);
        assertEquals("-", currentSquare.toString());
        currentSquare.makeAnything("→");
        currentSquare = AI.selectDownRight(board2,0,0);
        assertEquals("-", currentSquare.toString());
        currentSquare.makeAnything("↘");
        currentSquare = AI.selectDown(board2,0,0);
        assertEquals("-", currentSquare.toString());
        currentSquare.makeAnything("↓");
        
        // invalid directions
        currentSquare = AI.selectUp(board2,0,0);
        assertEquals(null, currentSquare);
        currentSquare = AI.selectLeft(board2,0,0);
        assertEquals(null, currentSquare);
        currentSquare = AI.selectUpLeft(board2,0,0);
        assertEquals(null, currentSquare);
        currentSquare = AI.selectUpRight(board2,0,0);
        assertEquals(null, currentSquare);
        currentSquare = AI.selectDownLeft(board2,0,0);
            
    }
    
    @Test
    void selectLocation() {
        var square = AI.selectLocation(board, x, y);
        assertEquals("X", square.toString());
        square = AI.selectLocation(board, 1, 0);
        assertEquals("-", square.toString());
        square = AI.selectLocation(board, 1, 5);
        assertEquals(null, square);
    }

    @Test
    void selectDown() {
        var square = AI.selectDown(board, x, y);
        square.makeAnything("↓");
        assertEquals("↓", square.toString());
    }

    @Test
    void selectUpLeft() {
        var square = AI.selectUpLeft(board, x, y);
        square.makeAnything("↖");
        assertEquals("↖", square.toString());
    }

    @Test
    void selectUpRight() {
        var square = AI.selectUpRight(board, x, y);
        square.makeAnything("↗");
        assertEquals("↗", square.toString());
    }

    @Test
    void selectDownLeft() {
        var square = AI.selectDownLeft(board, x, y);
        square.makeAnything("↙");
        assertEquals("↙", square.toString());
    }

    @Test
    void selectDownRight() {
        var square = AI.selectDownRight(board, x, y);
        square.makeAnything("↘");
        assertEquals("↘", square.toString());
    }

    @Test
    void selectUp() {
        var square = AI.selectUp(board, x, y);
        square.makeAnything("↑");
        assertEquals("↑", square.toString());
    }

    @Test
    void selectLeft() {
        var square = AI.selectLeft(board, x, y);
        square.makeAnything("←");
        assertEquals("←", square.toString());
    }

    @Test
    void selectRight() {
        var square = AI.selectRight(board, x, y);
        square.makeAnything("→");
        assertEquals("→", square.toString());
    }
    @AfterAll
    static void tearDownAfterClass() {
        board.displayBoard();
        System.out.println("--------------------");
        board2.displayBoard();
    }
}