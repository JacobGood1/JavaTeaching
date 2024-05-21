package GuessTheNumber;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DifficultyFactoryTest {

    @Test
    void chooseDifficulty() {
        assertEquals("EasyMode", DifficultyFactory.chooseDifficulty(DifficultyLevel.Easy).toString());
        assertEquals("MediumMode", DifficultyFactory.chooseDifficulty(DifficultyLevel.Medium).toString());
        assertEquals("HardMode", DifficultyFactory.chooseDifficulty(DifficultyLevel.Hard).toString());
        
    }
}