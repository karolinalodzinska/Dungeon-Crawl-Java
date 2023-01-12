package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;

public class Skeleton extends Actor {

    public static final int HEALTH = 5;
    public Skeleton(Cell cell) {
        super(cell, HEALTH);

    }

    @Override
    public String getTileName() {
        return "skeleton";
    }

    @Override
    public void decreaseHealth(int decrease){
        int  health = getHealth();
        health -= decrease;
        setHealth(health);
    }
}
