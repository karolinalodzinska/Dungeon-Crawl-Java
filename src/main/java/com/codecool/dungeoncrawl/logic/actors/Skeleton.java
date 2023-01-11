package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;

public class Skeleton extends Actor {
    private int ID = 0;
    private  int count = 0;
    public static final int HEALTH = 5;
    public Skeleton(Cell cell) {
        super(cell, HEALTH);
        ID = count++;
    }
    @Override
    public int getID() {
        return ID;
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
