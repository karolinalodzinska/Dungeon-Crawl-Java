package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.logic.actors.Player;

public class GameMap {
    private int width;
    private int height;
    private Cell[][] cells;
    Cell center;
    private Player player;

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
        centerPosition();
    }

    public void centerPosition(){
        int centerX;
        int centerY;

        if (player.getCell().getX() <= 10) {
            centerX = 10;
        } else {
            centerX = Math.min(player.getCell().getX(), width - 10);
        }

        if (player.getCell().getY() <= 10) {
            centerY = 10;
        } else {
            centerY = Math.min(player.getCell().getY(), height - 10);
        }

        center = cells[centerX][centerY];
    }

    public Cell getCenterCell() {
        return center;
    }


    public Player getPlayer() {
        return player;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

}
