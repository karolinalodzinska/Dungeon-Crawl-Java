package com.codecool.dungeoncrawl.logic.items;

import com.codecool.dungeoncrawl.logic.Cell;


public class Door extends Item {
    private boolean isOpen;

    public Door(Cell cell) {
        super(cell);
        this.isOpen = false;
    }

    public boolean isOpen(){
        return isOpen;
    }

    public void setOpen(boolean open){
        isOpen = open;
    }

    @Override
    public String getTileName() {
        return null;
    }
}
