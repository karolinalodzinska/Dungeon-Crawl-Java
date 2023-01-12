package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.logic.actors.Actor;
import com.codecool.dungeoncrawl.logic.actors.Skeleton;
import com.codecool.dungeoncrawl.logic.items.Item;

public class Cell implements Drawable {
    private CellType type;
    private Actor actor;
    private Item item;
    private GameMap gameMap;
    private int x, y;

    public Item getItem() {
        return item;
    }
    
    public void setItem(Item item) {
        this.item = item;
    }

    Cell(GameMap gameMap, int x, int y, CellType type) {
        this.gameMap = gameMap;
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public CellType getType() {
        return type;
    }

    public void setType(CellType type) {
        this.type = type;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public void deleteActorIfHealthIsZero(){
        if (this.actor == null){
            //pass
        }
        else if (actor.getHealth() <= 0 ){
            if (actor instanceof Skeleton)
            {
                actor = null;
            }
            else {
                actor = null;
                System.out.println("end");
            }
        }
    }

    public void deleteActor(){

        actor = null;
    }
    public Actor getActor() {
        return actor;
    }

    public Cell getNewCellForEnemy (int x, int y) {
        return gameMap.getCell(x , y );
    }


    public Cell getNeighbor(int dx, int dy) {
        return gameMap.getCell(x + dx, y + dy);
    }

    @Override
    public String getTileName() {
        if (actor != null) {
            return actor.getTileName();
        } else if (item != null) {
            return item.getTileName();
        } else {
            return type.getTileName();
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
