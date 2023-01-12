package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;

public class Warrior extends Actor {

    public static final int STRENGTH = 3;
    public static final int HEALTH  = 7;

    public Warrior(Cell cell) {
        super(cell, HEALTH);
    }

    public String getTileName() {
        return "warrior";
    }

    @Override
    public void decreaseHealth(int decrease){
        int  health = getHealth();
        health -= decrease;
        setHealth(health);
    }
}
