package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.logic.items.Sword;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SwordTest {
    GameMap map = new GameMap(3, 3, CellType.FLOOR);

    @Test
    void constructorTestPositive(){
        Sword swordTested = new Sword(new Cell(map, 1, 1, CellType.FLOOR));
        CellType expectedCellType = CellType.FLOOR;
        assertEquals(expectedCellType, swordTested.getCell().getType());
    }

    @Test
    void constructorTestNegative(){
        Sword swordTested = new Sword(new Cell(map, 1, 1, CellType.FLOOR));
        CellType expectedCellType = CellType.WALL;
        assertNotEquals(expectedCellType, swordTested.getCell().getType());
    }

    @Test
    void getTileNameTestPositive(){
        Sword swordTested = new Sword(new Cell(map, 1, 1, CellType.FLOOR));
        assertEquals("sword", swordTested.getTileName());
    }

    @Test
    void getTileNameTestNegative(){
        Sword swordTested = new Sword(new Cell(map, 1, 1, CellType.FLOOR));
        assertNotEquals("key", swordTested.getTileName());
    }
}


