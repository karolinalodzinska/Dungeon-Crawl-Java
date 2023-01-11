package com.codecool.dungeoncrawl.logic;
import com.codecool.dungeoncrawl.logic.items.*;
import com.codecool.dungeoncrawl.logic.actors.Player;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    public List<Item> inventory = new ArrayList<>();
    boolean hasKey = false;
    boolean hasSword = false;

    public Inventory(Inventory inventory) {
        this.inventory = (List<Item>) inventory;
        updateItems();
    }

    private void updateItems() {
        for (Item item : inventory) {

            if (item instanceof Key) {
                hasKey = true;
            }

            if (item instanceof Sword){
                hasSword = true;
            }

        }
    }

    public boolean hasSword(){
        return hasSword;
    }

    public boolean hasKey() {
        return hasKey;
    }

}
