package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;

public class Skeleton extends Actor {

    public static final int HEALTH = 5;
    public static final int STRENGTH = 2;
    public Skeleton(Cell cell) {
        super(cell, HEALTH);

    }

    @Override
    public int getStrength() {
        return STRENGTH;
    }

    @Override
    public String getTileName() {
        return "skeleton";
    }

    @Override
    public void consequenceOfFigthing(int decrease){
        int  health = getHealth();
        health -= decrease;
        setHealth(health);
    }
}
