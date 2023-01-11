package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.CellType;

public class Player extends Actor {
    public Player(Cell cell) {
        super(cell, 12);
    }

    public String getTileName() {
        return "player";
    }

    public void PlayerDecreaseHealth(int decrease) {
        int health = getHealth();
        health -= decrease;
        setHealth(health);
    }



    public void attemptMove(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);
        if (nextCell.getType() == CellType.FLOOR && nextCell.getActor() != null){
            System.out.println("enemy");
            PlayerDecreaseHealth(2);
           // SkeletonDecreaseHealth(5);

        }
        else if (nextCell.getType() == CellType.FLOOR && nextCell.getActor() == null) {
            move(dx, dy);

        }
    }

}
