package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.logic.items.Axe;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AxeTest {
    GameMap map = new GameMap(3, 3, CellType.FLOOR);

    @Test
    void constructorTestPositive(){
        Cell cell = new Cell(map, 1, 1, CellType.FLOOR);
        Axe axeTested = new Axe(cell);
        assertEquals(cell, axeTested.getCell());
    }

    @Test
    void getTileNameTestPositive(){
        Axe axeTested = new Axe(new Cell(map, 1, 1, CellType.FLOOR));
        assertEquals("axe", axeTested.getTileName());
    }

}
