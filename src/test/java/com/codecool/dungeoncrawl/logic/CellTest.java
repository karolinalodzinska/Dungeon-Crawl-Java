package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.logic.actors.Actor;
import com.codecool.dungeoncrawl.logic.actors.Player;
import com.codecool.dungeoncrawl.logic.actors.Skeleton;
import com.codecool.dungeoncrawl.logic.items.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {
    GameMap map = new GameMap(3, 3, CellType.FLOOR);

    @Test
    void getNeighbor() {
        Cell cell = map.getCell(1, 1);
        Cell neighbor = cell.getNeighbor(-1, 0);
        assertEquals(0, neighbor.getX());
        assertEquals(1, neighbor.getY());
    }

    @Test
    void cellOnEdgeHasNoNeighbor() {
        Cell cell = map.getCell(1, 0);
        assertEquals(null, cell.getNeighbor(0, -1));

        cell = map.getCell(1, 2);
        assertEquals(null, cell.getNeighbor(0, 1));
    }

    @Test
    void getItem_CellWithoutItem_ReturnsNull() {
        Cell cell = map.getCell(1, 1);
        assertNull(cell.getItem());
    }

    @Test
    void deleteActor_ActorNotExist_NoChange() {
        Cell cell = map.getCell(1, 1);
        Actor actor = cell.getActor();

        cell.deleteActor();

        assertEquals(actor, cell.getActor());
    }

    @Test
    void deleteActorIfHealthIsZero_ActorIsNull_DoesNothing() {
        Cell cell = map.getCell(1, 1);
        cell.deleteActorIfHealthIsZero();
        assertNull(cell.getActor());
    }

    @Test
    void deleteActorIfHealthIsZero_ActorIsSkeleton_DeletesActor() {
        Cell cell = map.getCell(1, 1);
        Skeleton skeleton = new Skeleton(cell);
        cell.setActor(skeleton);
        skeleton.setHealth(0);
        cell.deleteActorIfHealthIsZero();
        assertNull(cell.getActor());
    }

    @Test
    void deleteActorIfHealthIsZero_ActorIsPlayer_DeletesActor() {
        Cell cell = map.getCell(1, 1);
        Player player = new Player(cell);
        cell.setActor(player);
        player.setHealth(0);
        cell.deleteActorIfHealthIsZero();
        assertNull(cell.getActor());
    }

    @Test
    void deleteActorIfHealthIsZero_ActorIsPlayer_HealthIsGreaterThanZero_DoesNothing() {
        Cell cell = map.getCell(1, 1);
        Player player = new Player(cell);
        cell.setActor(player);
        player.setHealth(1);
        cell.deleteActorIfHealthIsZero();
        assertNotNull(cell.getActor());
    }

    @Test
    void getNewCellForEnemy_validInput_returnsCorrectCell() {
        Cell cell = map.getCell(0, 0);
        Cell newCell = cell.getNewCellForEnemy(2, 2);
        assertEquals(2, newCell.getX());
        assertEquals(2, newCell.getY());
    }

    @Test
    void setDoor_DoorObject_SetsDoorAttributeToGivenDoorObject(){
        Door door = new Door();
        Cell cell = map.getCell(1, 1);
        cell.setDoor(door);
        assertEquals(door, cell.getDoor());
    }

    @Test
    void getTileName_CellType_ReturnsCellTypeTileName(){
        Cell cell = map.getCell(1, 1);
        cell.setType(CellType.FLOOR);
        assertEquals("floor", cell.getTileName());
    }

    @Test
    void getTileName_Actor_ReturnsActorTileName(){
        Cell cell = map.getCell(1, 1);
        Actor actor = new Actor(cell, 1) {
            @Override
            public String getTileName() {
                return "actor tile";
            }
        };
        cell.setActor(actor);
        assertEquals("actor tile", cell.getTileName());
    }

    @Test
    void getTileName_Item_ReturnsItemTileName(){
        Cell cell = map.getCell(1, 1);
        Item item = new Item(cell) {
            @Override
            public String getTileName() {
                return "item tile";
            }
        };
        cell.setItem(item);
        assertEquals("item tile", cell.getTileName());
    }

    @Test
    void getTileName_ItemAndActor_ReturnsActorsTileName(){
        Cell cell = map.getCell(1, 1);

        Actor actor = new Actor(cell, 1) {
            @Override
            public String getTileName() {
                return "actor tile";
            }
        };

        cell.setActor(actor);
        Item item = new Item(cell) {
            @Override
            public String getTileName() {
                return "item tile";
            }
        };
        cell.setItem(item);
        assertEquals("actor tile", cell.getTileName());
    }

}