package com.codecool.dungeoncrawl.logic.items;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.Inventory;

public class Item {

    private Cell cell;
    private final int strength;
    private boolean isPickedUp;
    public boolean isPickedUp() {
        return isPickedUp;
    }

    public void setPickedUp(boolean pickedUp) {
        isPickedUp = pickedUp;
    }

    public Item(Cell cell) {
        this.cell = cell;
        this.cell.setItem(this);
        strength = 0;
    }

    public Cell getCell(){
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public void pickUp(Inventory inventory){
        inventory.pickUpItem(this);
    }

    public int getStrength() {
        return strength;
    }
}
