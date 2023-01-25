package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.logic.items.Axe;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class AxeTest {
    GameMap map = new GameMap(3, 3, CellType.FLOOR);

    @Test
    void getTileNameTestPositive(){
        Axe keyTested = new Axe(new Cell(map, 1, 1, CellType.FLOOR));
        assertEquals("axe", keyTested.getTileName());
    }

    @Test
    void getTileNameTestNegative(){
        Axe keyTested = new Axe(new Cell(map, 1, 1, CellType.FLOOR));
        assertNotEquals("key", keyTested.getTileName());
    }
}
