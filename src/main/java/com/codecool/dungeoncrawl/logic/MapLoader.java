package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.logic.actors.Magician;
import com.codecool.dungeoncrawl.logic.actors.Player;
import com.codecool.dungeoncrawl.logic.actors.Skeleton;
import com.codecool.dungeoncrawl.logic.actors.Warrior;
import com.codecool.dungeoncrawl.logic.items.Axe;
import com.codecool.dungeoncrawl.logic.items.Key;
import com.codecool.dungeoncrawl.logic.items.Potion;
import com.codecool.dungeoncrawl.logic.items.Sword;
import com.codecool.dungeoncrawl.ui.Randomize;

import java.io.InputStream;
import java.util.Scanner;

public class MapLoader {

    private static InputStream levelSelector(int level){
        String level1 = "/map.txt";
        String level2 = "/map2.txt";
        if (level == 1){
            return MapLoader.class.getResourceAsStream(level1);
        } else {
            return MapLoader.class.getResourceAsStream(level2);
        }
    }
    public static GameMap loadMap(int level) {
//        InputStream is = MapLoader.class.getResourceAsStream("/map.txt");
        Scanner scanner = new Scanner(levelSelector(level));
        int width = scanner.nextInt();
        int height = scanner.nextInt();

        scanner.nextLine(); // empty line

        boolean isMagicianOnMap = false;
        int counterHowManyTimesMagicianDidntAppearOnMap = 0;

        GameMap map = new GameMap(width, height, CellType.EMPTY);
        for (int y = 0; y < height; y++) {
            String line = scanner.nextLine();
            for (int x = 0; x < width; x++) {
                if (x < line.length()) {
                    Cell cell = map.getCell(x, y);
                    switch (line.charAt(x)) {
                        case ' ':
                            cell.setType(CellType.EMPTY);
                            break;
                        case '#':
                            cell.setType(CellType.WALL);
                            break;
                        case '.':
                            cell.setType(CellType.FLOOR);
                            break;
                        case 's':
                            cell.setType(CellType.FLOOR);
                            map.setSkeleton(new Skeleton(cell));
                            break;
                        case 'w':
                            cell.setType(CellType.FLOOR);
                            map.setWarrior(new Warrior(cell));
                            break;
                        case 'b' :
                            Randomize randomize = new Randomize();

                            if (randomize.getrandomNumberForMagician() == 0 && !isMagicianOnMap){
                                isMagicianOnMap = true;
                                cell.setType(CellType.FLOOR);
                                map.setMagician(new Magician(cell));
                            } else if (counterHowManyTimesMagicianDidntAppearOnMap == 3 ) {
                                cell.setType(CellType.FLOOR);
                                map.setMagician(new Magician(cell));
                            } else {
                                counterHowManyTimesMagicianDidntAppearOnMap++;
                                cell.setType(CellType.FLOOR);
                            }
                            break;
                        case '@':
                            cell.setType(CellType.FLOOR);
                            map.setPlayer(new Player(cell));
                            break;
                        case 'p':
                            cell.setType(CellType.FLOOR);
                            new Potion(cell);
                            break;
                        case 'k':
                            cell.setType(CellType.FLOOR);
                            new Key(cell);
                            break;
                        case 'm':
                            cell.setType(CellType.FLOOR);
                            new Sword(cell);
                            break;
                        case 'a':
                            cell.setType(CellType.FLOOR);
                            new Axe(cell);
                            break;
                        case 'o':
                            cell.setType(CellType.OPEN_DOOR);
                            break;
                        case 'c':
                            Door door = new Door();
                            cell.setDoor(door);
                            cell.setType(CellType.CLOSED_DOOR);
                            break;
                        default:
                            throw new RuntimeException("Unrecognized character: '" + line.charAt(x) + "'");
                    }
                }
            }
        }
        return map;
    }

}
