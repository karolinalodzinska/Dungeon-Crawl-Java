package com.codecool.dungeoncrawl.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class GameState extends BaseModel {
    private Timestamp savedAt;
    private Integer currentMap;
    private List<String> discoveredMaps = new ArrayList<>();
    private PlayerModel player;

    public GameState(int currentMap, Timestamp savedAt, PlayerModel player) {
        this.currentMap = currentMap;
        this.savedAt = savedAt;
        this.player = player;
    }


    public Timestamp getSavedAt() {
        return savedAt;
    }

    public void setSavedAt(Timestamp savedAt) {
        this.savedAt = savedAt;
    }

    public Integer getCurrentMap() {
        return currentMap;
    }

    public void setCurrentMap(Integer currentMap) {
        this.currentMap = currentMap;
    }

    public List<String> getDiscoveredMaps() {
        return discoveredMaps;
    }

    public void addDiscoveredMap(String map) {
        this.discoveredMaps.add(map);
    }

    public PlayerModel getPlayer() {
        return player;
    }

    public void setPlayer(PlayerModel player) {
        this.player = player;
    }

    public String getPlayerName(){
        return player.getPlayerName();
    }

}
