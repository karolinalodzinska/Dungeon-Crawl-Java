package com.codecool.dungeoncrawl.dao;

import com.codecool.dungeoncrawl.model.GameState;
import com.codecool.dungeoncrawl.model.PlayerModel;
import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public class GameDatabaseManager {
    private PlayerDao playerDao;
    private GameStateDao gameStateDao;

    public void setup() throws SQLException {
        DataSource dataSource = connect();
        playerDao = new PlayerDaoJdbc(dataSource);
        gameStateDao = new GameStateDaoJdbc(dataSource);
    }

    public void savePlayer(PlayerModel playerModel) {
        playerDao.add(playerModel);

    }

    public void updatePlayer(PlayerModel playerModel){
        playerDao.update(playerModel);
    }

    public List<PlayerModel> getAllPlayers(){
        return playerDao.getAll();
    }

    public void saveMap(int currentMap, Timestamp time, PlayerModel playerModel){
        GameState gameModel = new GameState(currentMap, time, playerModel);
        gameStateDao.add(gameModel);
    }

    public void updateMap(int currentMap, Timestamp time, PlayerModel playerModel){
        GameState gameModel = new GameState(currentMap, time, playerModel);
        gameStateDao.update(gameModel);
    }

    public PlayerModel getPlayer(int id){
        PlayerModel player =  playerDao.get(id);
        return  player;
    }

    public GameState getGameState(PlayerModel player){
        GameState gamestate = gameStateDao.get(player);
        return gamestate;
    }

    private DataSource connect() throws SQLException {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        String dbName = System.getenv("PSQL_DB_NAME");
        String user = System.getenv("PSQL_USER_NAME");
        String password = System.getenv("PSQL_PASSWORD");

        dataSource.setDatabaseName(dbName);
        dataSource.setUser(user);
        dataSource.setPassword(password);

        System.out.println("Trying to connect");
        dataSource.getConnection().close();
        System.out.println("Connection ok.");

        return dataSource;
    }

    public boolean doesExist(String name){
        return playerDao.doesExist(name);
    }

}
