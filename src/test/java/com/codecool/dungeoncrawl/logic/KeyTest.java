package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.logic.items.Key;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class KeyTest {
    GameMap map = new GameMap(3, 3, CellType.FLOOR);

    @Test
    void getTileNameTestPositive(){
        Key keyTested = new Key(new Cell(map, 1, 1, CellType.FLOOR));
        assertEquals("key", keyTested.getTileName());
    }

    @Test
    void getTileNameTestNegative(){
        Key keyTested = new Key(new Cell(map, 1, 1, CellType.FLOOR));
        assertNotEquals("potion", keyTested.getTileName());
    }
}
