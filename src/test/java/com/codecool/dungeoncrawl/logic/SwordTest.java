package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.logic.items.Sword;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SwordTest {
    GameMap map = new GameMap(3, 3, CellType.FLOOR);

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


