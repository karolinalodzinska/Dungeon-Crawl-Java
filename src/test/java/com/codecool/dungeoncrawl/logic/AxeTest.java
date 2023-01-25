package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.logic.items.Axe;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AxeTest {
    GameMap map = new GameMap(3, 3, CellType.FLOOR);

    @Test
    void constructorTestPositive(){
        Axe axeTested = new Axe(new Cell(map, 1, 1, CellType.FLOOR));
        CellType expectedCellType = CellType.FLOOR;
        assertEquals(expectedCellType, axeTested.getCell().getType());
    }

    @Test
    void constructorTestNegative(){
        Axe axeTested = new Axe(new Cell(map, 1, 1, CellType.FLOOR));
        CellType expectedCellType = CellType.WALL;
        assertNotEquals(expectedCellType, axeTested.getCell().getType());
    }

    @Test
    void getTileNameTestPositive(){
        Axe axeTested = new Axe(new Cell(map, 1, 1, CellType.FLOOR));
        assertEquals("axe", axeTested.getTileName());
    }

    @Test
    void getTileNameTestNegative(){
        Axe axeTested = new Axe(new Cell(map, 1, 1, CellType.FLOOR));
        assertNotEquals("key", axeTested.getTileName());
    }
}
