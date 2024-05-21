package GuessTheNumber;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GuessTheNumberTest {

    @Test
    void guessTheNumberFeedBack() {
        assertEquals("Too high", GuessTheNumber.guessTheNumberFeedBack(6, 5));
        assertEquals("Too low", GuessTheNumber.guessTheNumberFeedBack(4, 5));
        assertEquals("you win", GuessTheNumber.guessTheNumberFeedBack(5, 5));
    }
}