package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.logic.actors.Player;
import com.codecool.dungeoncrawl.logic.actors.Skeleton;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SkeletonTest {
    Skeleton skeleton;
    Player player;

    @BeforeEach
    void generateSkeleton(){
        skeleton = new Skeleton(new Cell(new GameMap(10,10, CellType.FLOOR),5,5,CellType.FLOOR));

    }

    @Test
    void move() {
        skeleton.move(1,0);
        int afterX = skeleton.getX();
        int afterY = skeleton.getY();
        assertEquals(6,afterX);
        assertEquals(5,afterY);
    }

    @Test
    void getTileName() {
        assertEquals("skeleton", skeleton.getTileName());

    }



}

