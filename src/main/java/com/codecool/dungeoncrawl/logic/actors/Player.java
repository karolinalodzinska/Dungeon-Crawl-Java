package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.items.*;
import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.CellType;
import com.codecool.dungeoncrawl.ui.Main;

import java.util.ArrayList;
import java.util.HashMap;

public class Player extends Actor {
    private Main main;

    private ArrayList<Item> inventory;
    public static final int STRENGTH = 5;
    public static final int HEALTH = 10;
    public Player(Cell cell) {

        super(cell);
        this.setHealth(HEALTH);
        this.setStrength(STRENGTH);
        this.inventory = new ArrayList<>();
    }


    public void setMain(Main main){
        this.main = main;
    }

    public String getTileName() {
        return "player";
    }

    public void attemptMove(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);
        if (nextCell.getType() == CellType.FLOOR && nextCell.getActor() == null) {
            move(dx, dy);
        } else if (nextCell.getType() == CellType.OPEN_DOOR || nextCell.getType() == CellType.CLOSED_DOOR) {
            Door door = nextCell.getDoor();
            if (nextCell.getType() == CellType.OPEN_DOOR) {
                move(dx, dy);
            } else {
                for (Item item : inventory) {
                    if (item instanceof Key) {
                        Key key = (Key) item;
                        if (key.getDoor() == door) {
                            inventory.remove(item);
                            door.setOpen(true);
                            nextCell.setType(CellType.OPEN_DOOR);
                            move(dx, dy);
                            main.refresh();
                            return;
                        }
                    }
                }
            }
        }
    }



    public void addToInventory(Item item) {
        inventory.add(item);
    }
    public void setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }
    public void removeFromInventory(Item item) {
        inventory.remove(item);
    }
    public ArrayList getInventory() {
        return inventory;
    }

    public void pickUpItem() {
        if (this.getCell().getItem() != null) {
            addToInventory(this.getCell().getItem());
            if (this.getCell().getItem() instanceof Sword) {
                this.setStrength(getStrength()+2);
            } else if (this.getCell().getItem() instanceof Potion) {
                this.setHealth(getHealth()+3);
            }

            System.out.println(inventory);
            this.getCell().setItem(null);
        }
    }

    public String displayInventory() {

        StringBuilder display = new StringBuilder();
        int keyCount = 0;
        int swordCount = 0;
        HashMap<String, Integer> inventoryDict = new HashMap<String, Integer>();
        for(Item item : inventory){
            if(item instanceof Key){
                keyCount += 1;
                if(keyCount <= 1){
                    inventoryDict.put(item.getTileName(), keyCount);
                }else{
                    inventoryDict.put("Key", keyCount);
                }

            } else if (item instanceof Sword){
                swordCount += 1;
                if(keyCount <= 1){
                    inventoryDict.put(item.getTileName(), swordCount);
                }else{
                    inventoryDict.put("Sword", swordCount);
                }

            }
        }
        for(HashMap.Entry<String, Integer> element: inventoryDict.entrySet()){
            display.append(element.getKey() + ": " + element.getValue());
            display.append("\n");
        }


        return display.toString();
    }

}

