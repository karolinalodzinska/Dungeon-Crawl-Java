package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.items.Item;
import com.codecool.dungeoncrawl.logic.items.Key;
import com.codecool.dungeoncrawl.logic.items.Sword;

import java.util.ArrayList;
import java.util.HashMap;

public class Player extends Actor {


    private ArrayList<Item> inventory = new ArrayList<Item>();
    public static final int HEALTH =10;
    private int playerOnMap;

    public Player(Cell cell) {

        super(cell);
        this.setHealth(HEALTH);
        this.inventory= new ArrayList<Item>();
        setPlayerOnMap(1);
    }
    public int getPlayerOnMap() {
        int playerOnMap = 0;
        return playerOnMap;
    }
    private void setPlayerOnMap(int playerOnMap) {
        this.playerOnMap = playerOnMap;
    }

    public String getTileName() {
        return "player";
    }


    public void addToInventory(Item item) {

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

    public String displayInventory() {
        StringBuilder display = new StringBuilder();
        int keyCount = 0;
        int swordCount = 0;
        HashMap<String, Integer> inventory_dict = new HashMap<String, Integer>();
        for(Item item : inventory){
            if(item instanceof Key){
                keyCount+=1;
                if(keyCount <= 1){
                    inventory_dict.put(((Key) item).getTileName(), keyCount);
                }else{
                    inventory_dict.put("Key", keyCount);
                }

            } else if (item instanceof Sword){
                swordCount += 1;
                if(keyCount <= 1){
                    inventory_dict.put(item.getTileName(), swordCount);
                }else{
                    inventory_dict.put("Sword", swordCount);
                }

            }
        }
        for(HashMap.Entry<String, Integer> element: inventory_dict.entrySet()){
            display.append(element.getKey()+": "+ element.getValue());
            display.append("\n");
        }


        return display.toString();
    }

}
