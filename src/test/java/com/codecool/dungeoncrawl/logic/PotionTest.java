package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.logic.items.Potion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PotionTest {
    GameMap map = new GameMap(3, 3, CellType.FLOOR);

    @Test
    void getTileNameTestPositive(){
        Potion keyTested = new Potion(new Cell(map, 1, 1, CellType.FLOOR));
        assertEquals("potion", keyTested.getTileName());
    }

    @Test
    void getTileNameTestNegative(){
        Potion keyTested = new Potion(new Cell(map, 1, 1, CellType.FLOOR));
        assertNotEquals("key", keyTested.getTileName());
    }
}

