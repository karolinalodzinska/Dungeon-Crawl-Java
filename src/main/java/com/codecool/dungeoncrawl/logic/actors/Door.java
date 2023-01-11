package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.actors.Actor;

public class Door extends Actor {
    private boolean isOpen;

    public Door(Cell cell) {
        super(cell);
        this.isOpen = false;
    }

    public void open(){
        this.isOpen = true;
    }

    public boolean isOpen(){
        return isOpen;
    }

    public String getTileName(){
        return isOpen ? "open_door" : "closed_door";
    }
}
