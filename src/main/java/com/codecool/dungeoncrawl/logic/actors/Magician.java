package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;

public class Magician extends Actor {

    public static final int STRENGTH = 6;
    public static final int HEALTH  = 15;

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


    public void consequenceOfFigthing(int decrease){
        int  health = getHealth();
        health -= decrease;
        setHealth(health);
        Cell cell1 = cell.getNewCellForEnemy(19, 9);
        cell1.setActor(new Magician(cell1));

        this.cell.deleteActor();
    }


//
}
