package com.codecool.dungeoncrawl.logic.items;

import com.codecool.dungeoncrawl.logic.Cell;

public class Key extends Item{
    private Door door;

    public Key(Cell cell, Door door) {
        super(cell);
        this.door = door;
    }

    public Door getDoor(){
        return door;
    }

    @Override
    public String getTileName() {
        return "key";
    }

}
