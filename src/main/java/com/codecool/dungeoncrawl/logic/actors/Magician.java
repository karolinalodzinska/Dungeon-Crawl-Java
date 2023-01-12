package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;

public class Magician extends Actor {

    public static final int STRENGTH = 5;
    public static final int HEALTH  = 6;



    public Magician(Cell cell) {
        super(cell, HEALTH);
    }

    @Override
    public int getStrength() {
        return STRENGTH;
    }

    public String getTileName() {
        return "magician";
    }

    public void decreaseHealth(int decrease,int dx,int dy,Cell nextCell){
        int  health = getHealth();
        health -= decrease;
        setHealth(health);
        nextCell.changePosition();

    }

//
}
