package Teaching;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DragonCaveTest {

    @Test
    void chooseCave() {
        assertEquals("you win", DragonCave.chooseCave("1"));
        assertEquals("you lose", DragonCave.chooseCave("2"));
    }
}