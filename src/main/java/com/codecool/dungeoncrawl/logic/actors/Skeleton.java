package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;

public class Skeleton extends Actor {
    public Skeleton(Cell cell) {
        super(cell, 5);
    }

    @Override
    public String getTileName() {
        return "skeleton";
    }

}
