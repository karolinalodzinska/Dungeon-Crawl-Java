package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.Drawable;

public abstract class Actor implements Drawable {
    Cell cell;
    private int strength;
    private int health;

    public Actor(Cell cell) {
        this.cell = cell;
        this.cell.setActor(this);
        this.health = getHealth();
        this.strength = getStrength();
    }

    public int getHealth(int health) {
        return this.health;
    }

    public void move(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);
        cell.setActor(null);
        nextCell.setActor(this);
        cell = nextCell;
    }

    public int getHealth() {
        return health;
    }

    public int getStrength() { return strength;}

    public void setHealth(int health) {
        this.health = health;
    }

    public Cell getCell() {
        return cell;
    }

    public int getX() {
        return cell.getX();
    }

    public int getY() {
        return cell.getY();
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

}
