package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.CellType;
import com.codecool.dungeoncrawl.logic.items.Item;
import com.codecool.dungeoncrawl.logic.items.Key;

import java.util.ArrayList;
import java.util.List;

public class Player extends Actor {
    private List<Item> inventory = new ArrayList<>();
    public Player(Cell cell) {
        super(cell);
    }

    public String getTileName() {
        return "player";
    }

    public void attemptMove(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);
        if (nextCell.getActor() instanceof Door) {
            Door door = (Door) nextCell.getActor();
            if (door.isOpen() || inventory.stream().anyMatch(i -> i instanceof Key)) {
                move(dx, dy);
                inventory.removeIf(i -> i instanceof Key);
                door.open();
                nextCell.setType(CellType.OPEN_DOOR);
            }
        } else if (nextCell.getType() == CellType.FLOOR && nextCell.getActor() == null) {
            move(dx, dy);
        }
    }
    public void addItem(Item item){
        inventory.add(item);
    }
}


