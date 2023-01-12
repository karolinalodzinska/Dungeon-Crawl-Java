package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.logic.actors.Magician;
import com.codecool.dungeoncrawl.logic.actors.Player;
import com.codecool.dungeoncrawl.logic.actors.Skeleton;
import com.codecool.dungeoncrawl.logic.actors.Warrior;

public class GameMap {
    private int width;
    private int height;
    private Cell[][] cells;

    private Player player;

    private Skeleton skeleton;

    private Warrior warrior;

    private Magician magician;

    public GameMap(int width, int height, CellType defaultCellType) {
        this.width = width;
        this.height = height;
        cells = new Cell[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                cells[x][y] = new Cell(this, x, y, defaultCellType);
            }
        }
    }

    public Cell getCell(int x, int y) {
        return cells[x][y];
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    public void setSkeleton(Skeleton skeleton) {
        this.skeleton = skeleton;
    }

    public Player getPlayer() {
        return player;
    }

    public void setWarrior(Warrior warrior) {
        this.warrior = warrior;
    }
    public void setMagician(Magician magician) {
        this.magician = magician;
    }


    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
