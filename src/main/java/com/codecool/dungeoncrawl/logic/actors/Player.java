package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Door;
import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.CellType;
import com.codecool.dungeoncrawl.logic.items.Item;
import com.codecool.dungeoncrawl.logic.items.Key;
import com.codecool.dungeoncrawl.logic.items.Axe;
import com.codecool.dungeoncrawl.logic.items.Potion;
import com.codecool.dungeoncrawl.logic.items.Sword;

import java.util.ArrayList;
import java.util.HashMap;

public class Player extends Actor {
    private String name;

    private ArrayList<Item> inventory;
    private boolean changeMap = false;
    public static final int STRENGTH = 5;
    public static final int HEALTH  = 30;
    public Player(Cell cell) {
        super(cell, HEALTH);
        this.setStrength(STRENGTH);
        this.inventory = new ArrayList<>();
    }

    public Player(Cell cell, String name) {
        super(cell, HEALTH);
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getTileName() {
        return "player";
    }

    @Override
    public void consequenceOfFigthing(int decrease){
        int  health = getHealth();
        health -= decrease;
        setHealth(health);
    }

    public boolean getChangeMap() {
        return changeMap;
    }

    public void setChangeMap(boolean changeMap) {
        this.changeMap = changeMap;
    }

    public void attemptMove(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);

        if (nextCell.getType() == CellType.FLOOR && nextCell.getActor() != null){
            consequenceOfFigthing(nextCell.getActor().getStrength());
            nextCell.getActor().consequenceOfFigthing(this.getStrength());
            nextCell.deleteActorIfHealthIsZero();

        } else if (nextCell.getType() == CellType.FLOOR && nextCell.getActor() == null) {
            move(dx, dy);

        } else if (nextCell.getType() == CellType.OPEN_DOOR || nextCell.getType() == CellType.CLOSED_DOOR) {
            Door door = nextCell.getDoor();
            if (nextCell.getType() == CellType.OPEN_DOOR) {
                move(dx, dy);

            } else {
                for (Item item : inventory) {
                    if (item instanceof Key) {
                        inventory.remove(item);
                        door.setOpen(true);
                        nextCell.setType(CellType.OPEN_DOOR);
                        move(dx, dy);
                        return;

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
        int axeCount = 0;

        HashMap<String, Integer> inventoryDict = new HashMap<String, Integer>();
        for(Item item : inventory){
            if(item instanceof Key){
                keyCount += 1;
                if(keyCount <= 1){
                    inventoryDict.put(item.getTileName(), keyCount);
                }else{
                    inventoryDict.put("key", keyCount);
                }

            } else if (item instanceof Sword) {
                swordCount += 1;
                if (swordCount <= 1) {
                    inventoryDict.put(item.getTileName(), swordCount);
                } else {
                    inventoryDict.put("sword", swordCount);
                }
            }

         else if (item instanceof Axe) {
            axeCount += 1;
            if (axeCount <= 1) {
                inventoryDict.put(item.getTileName(), axeCount);
            } else {
                inventoryDict.put("axe", axeCount);
            }
        }
        }

        for(HashMap.Entry<String, Integer> element: inventoryDict.entrySet()){
            if(element.getKey() == "key") { display.append("\uD83D\uDDDD   " + " : " + element.getValue()); }
            else if(element.getKey() == "sword") { display.append("\uD83D\uDDE1  " + " : " + element.getValue()); }
            else if(element.getKey() == "axe") { display.append("⛏  " + " : " + element.getValue()); }

            display.append("\n");
        }


        return display.toString();
    }


}

