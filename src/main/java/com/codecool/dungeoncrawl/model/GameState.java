package com.codecool.dungeoncrawl.model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class GameState extends BaseModel {
    private LocalTime savedAt;
    private Integer currentMap;
    private List<String> discoveredMaps = new ArrayList<>();
    private PlayerModel player;

    public GameState(int currentMap, LocalTime savedAt, PlayerModel player) {
        this.currentMap = currentMap;
        this.savedAt = savedAt;
        this.player = player;
    }


    public LocalTime getSavedAt() {
        return savedAt;
    }

    public void setSavedAt(LocalTime savedAt) {
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
