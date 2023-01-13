package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;

public class Warrior extends Actor {

    public static final int STRENGTH = 5;
    public static final int HEALTH  = 10;

    public Warrior(Cell cell) {
        super(cell, HEALTH);
    }

    @Override
    public int getStrength() {
        return STRENGTH;
    }

    public String getTileName() {
        return "warrior";
    }

    @Override
    public void consequenceOfFigthing(int decrease){
        int  health = getHealth();
        health -= decrease;
        setHealth(health);
        int newY;
        if(this.cell.getX() == 4) {
            newY  = 5;
        }
        else {
            newY = 4;
        }
        Cell cell1 = cell.getNewCellForEnemy(newY, 7);
        cell1.setActor(new Warrior(cell1));
        System.out.println(this.cell.getActor().getHealth());
        this.cell.deleteActor();
    }
}
