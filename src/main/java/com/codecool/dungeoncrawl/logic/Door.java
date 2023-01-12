package com.codecool.dungeoncrawl.logic;

public class Door {
    private boolean isOpen;

    public Door() {
        this.isOpen = false;
    }

    public boolean isOpen(){
        return isOpen;
    }

    public void setOpen(boolean open){
        isOpen = open;
    }
}
