package com.codecool.dungeoncrawl.logic;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DoorTest {
    @Test
    public void isOpen_Door_ReturnsFalse() {
        Door door = new Door();
        assertFalse(door.isOpen());
    }

    @Test
    public void setOpen_True_SetsOpenToTrue() {
        Door door = new Door();
        door.setOpen(true);
        assertTrue(door.isOpen());
    }

    @Test
    public void setOpen_False_SetsOpenToFalse() {
        Door door = new Door();
        door.setOpen(false);
        assertFalse(door.isOpen());
    }

}
