package com.codecool.dungeoncrawl.ui;
import java.util.Random;

public class Randomize {

    private int randomNumberForMagician;
    public Randomize() {

        Random rand = new Random();

        randomNumberForMagician = rand.nextInt(4);
    }

    public int getrandomNumberForMagician() {
        return randomNumberForMagician;
    }
}
