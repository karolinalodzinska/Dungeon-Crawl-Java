package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.logic.actors.Player;
import com.codecool.dungeoncrawl.logic.items.Key;
import com.codecool.dungeoncrawl.logic.items.Sword;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.codecool.dungeoncrawl.logic.CellType.FLOOR;
import static com.codecool.dungeoncrawl.logic.actors.Warrior.STRENGTH;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    GameMap gameMap;
    Player player;

    @BeforeEach
    void setUp() {
        gameMap = new GameMap(3, 3, CellType.FLOOR);
        player = new Player(gameMap.getCell(1, 1));
    }

}