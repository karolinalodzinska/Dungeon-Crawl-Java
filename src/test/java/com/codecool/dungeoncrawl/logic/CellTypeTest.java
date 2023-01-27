package com.codecool.dungeoncrawl.logic;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CellTypeTest {

    // positive test cases
    @Test
    void getTileName_Empty_ReturnsEmpty() {
        CellType floor = CellType.EMPTY;
        assertEquals("empty", floor.getTileName());
    }

    @Test
    void getTileName_Floor_ReturnsFloor() {
        CellType floor = CellType.FLOOR;
        assertEquals("floor", floor.getTileName());
    }

    @Test
    void getTileName_Wall_ReturnsWall() {
        CellType wall = CellType.WALL;
        assertEquals("wall", wall.getTileName());
    }

    @Test
    void getTileName_OpenDoor_ReturnsOpenDoor() {
        CellType openDoor = CellType.OPEN_DOOR;
        assertEquals("open_door", openDoor.getTileName());
    }

    @Test
    void getTileName_ClosedDoor_ReturnsClosedDoor() {
        CellType closedDoor = CellType.CLOSED_DOOR;
        assertEquals("closed_door", closedDoor.getTileName());
    }

    // negative test cases
    @Test
    void getTileName_Empty_ReturnsAnotherCellType() {
        CellType floor = CellType.EMPTY;
        String expectedName = "floor";
        assertNotEquals(expectedName, floor.getTileName());
    }

    @Test
    void getTileName_Floor_ReturnsAnotherCellType() {
        CellType floor = CellType.FLOOR;
        String expectedName = "empty";
        assertNotEquals(expectedName, floor.getTileName());
    }

    @Test
    void getTileName_Wall_ReturnsAnotherCellType() {
        CellType floor = CellType.WALL;
        String expectedName = "empty";
        assertNotEquals(expectedName, floor.getTileName());
    }

    @Test
    void getTileName_OpenDoor_ReturnsAnotherCellType() {
        CellType floor = CellType.OPEN_DOOR;
        String expectedName = "empty";
        assertNotEquals(expectedName, floor.getTileName());
    }

    @Test
    void getTileName_ClosedDoor_ReturnsAnotherCellType() {
        CellType floor = CellType.CLOSED_DOOR;
        String expectedName = "empty";
        assertNotEquals(expectedName, floor.getTileName());
    }

}

