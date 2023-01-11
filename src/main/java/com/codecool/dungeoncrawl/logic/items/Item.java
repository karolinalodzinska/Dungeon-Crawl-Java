package com.codecool.dungeoncrawl.logic.items;

import com.codecool.dungeoncrawl.logic.Cell;

public abstract class Item {

    private Cell cell;

    public Item(Cell cell) {
        this.cell = cell;
        this.cell.setItem(this);
    }

    public Cell getCell(){
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }



    public String getTileName(){
        return "Item";
    }


}
