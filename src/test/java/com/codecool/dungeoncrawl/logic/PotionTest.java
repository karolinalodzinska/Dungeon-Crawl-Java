package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.logic.items.Potion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PotionTest {
    GameMap map = new GameMap(3, 3, CellType.FLOOR);

    @Test
    void constructorTestPositive(){
        Potion potionTested = new Potion(new Cell(map, 1, 1, CellType.FLOOR));
        CellType expectedCellType = CellType.FLOOR;
        assertEquals(expectedCellType, potionTested.getCell().getType());
    }

    @Test
    void constructorTestNegative(){
        Potion potionTested = new Potion(new Cell(map, 1, 1, CellType.FLOOR));
        CellType expectedCellType = CellType.WALL;
        assertNotEquals(expectedCellType, potionTested.getCell().getType());
    }

    @Test
    void getTileNameTestPositive(){
        Potion potionTested = new Potion(new Cell(map, 1, 1, CellType.FLOOR));
        assertEquals("potion", potionTested.getTileName());
    }

    @Test
    void getTileNameTestNegative(){
        Potion potionTested = new Potion(new Cell(map, 1, 1, CellType.FLOOR));
        assertNotEquals("key", potionTested.getTileName());
    }
}

