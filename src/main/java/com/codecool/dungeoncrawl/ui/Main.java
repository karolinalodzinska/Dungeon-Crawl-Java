package com.codecool.dungeoncrawl.ui;

import com.codecool.dungeoncrawl.dao.GameDatabaseManager;
import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.CellType;
import com.codecool.dungeoncrawl.logic.GameMap;
import com.codecool.dungeoncrawl.logic.MapLoader;
import com.codecool.dungeoncrawl.logic.actors.Actor;
import com.codecool.dungeoncrawl.model.PlayerModel;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class Main extends Application {
    private int currentMap = 1;

    final private int CANVAS_WIDTH = 20;
    final private int CANVAS_HEIGHT = 20;
    GameMap map = new MapLoader().loadMap(currentMap);
    Canvas canvas = new Canvas(
            CANVAS_WIDTH * Tiles.TILE_WIDTH,
            CANVAS_HEIGHT * Tiles.TILE_WIDTH);
    GraphicsContext context = canvas.getGraphicsContext2D();
    Label playerHealthLabel = new Label();
    Label attackStrengthLabel = new Label();
    Button pickUpButton = new Button("Pick up");

    Label playerInventory = new Label("INVENTORY: ");
    GameDatabaseManager dbManager;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane ui = new GridPane();
        ui.setPrefWidth(200);
        ui.setPadding(new Insets(10));

        ui.add(new Label("PLayer Health: "), 0, 0);
        ui.add(playerHealthLabel, 1, 0);


        ui.add(new Label("  "), 0, 2);
        ui.add(new Label("Attack Strength: "), 0, 1);
        ui.add(attackStrengthLabel, 1, 1);
        ui.add(new Label("  "), 0, 4);

        ui.add(pickUpButton, 0, 5);
        pickUpButton.setOnAction(mousedown -> {
            map.getPlayer().pickUpItem();
            refresh();
        });

        ui.add(new Label("  "), 0, 6);
        pickUpButton.setFocusTraversable(false);
        ui.add(playerInventory, 0, 8);


        BorderPane borderPane = new BorderPane();

        borderPane.setCenter(canvas);
        borderPane.setRight(ui);

        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);
        refresh();
        scene.setOnKeyPressed(this::onKeyPressed);
        scene.setOnKeyReleased(this::onKeyReleased);


        primaryStage.setTitle("Dungeon Crawl");
        primaryStage.show();
    }

    private void onKeyReleased(KeyEvent keyEvent) {
        KeyCombination exitCombinationMac = new KeyCodeCombination(KeyCode.W, KeyCombination.SHORTCUT_DOWN);
        KeyCombination exitCombinationWin = new KeyCodeCombination(KeyCode.F4, KeyCombination.ALT_DOWN);
        if (exitCombinationMac.match(keyEvent)
                || exitCombinationWin.match(keyEvent)
                || keyEvent.getCode() == KeyCode.ESCAPE) {
            exit();
        }
    }

    private void onKeyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
            case UP:
                map.getPlayer().attemptMove(0, -1);
                break;
            case DOWN:
                map.getPlayer().attemptMove(0, 1);
                break;
            case LEFT:
                map.getPlayer().attemptMove(-1, 0);
                break;
            case RIGHT:
                map.getPlayer().attemptMove(1, 0);
                break;
            case S:
                Popup pop = new Popup();
                pop.show(createWindowForSavePopup());
                break;
        }

        map.centerPosition();
        refresh();

        if (isPlayerDead(map.getPlayer())) {
            System.out.println("You lose ---------------------------------------------------");
        }
    }

    public void refresh() {

        int minX = map.getCenterCell().getX() - CANVAS_WIDTH / 2;
        int minY = map.getCenterCell().getY() - CANVAS_HEIGHT / 2;
        int maxX = map.getCenterCell().getX() + CANVAS_WIDTH / 2;
        int maxY = map.getCenterCell().getY() + CANVAS_HEIGHT / 2;

        context.setFill(Color.BLACK);
        context.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        for (int x = minX; x < maxX; x++) {
            for (int y = minY; y < maxY; y++) {
                Cell cell = map.getCell(x, y);
                if (cell.getActor() != null) {
                    Tiles.drawTile(context, cell.getActor(), x - minX, y - minY);
                } else {
                    Tiles.drawTile(context, cell, x - minX, y - minY);
                }
            }
        }
        playerInventory.setText(map.getPlayer().displayInventory());
        attackStrengthLabel.setText("" + map.getPlayer().getStrength());
        playerHealthLabel.setText("" + map.getPlayer().getHealth());

        if (isPlayerDead(map.getPlayer())) {
            playerHealthLabel.setText("YOU DIED!");
        }

        if (map.getCell(map.getPlayer().getX(), map.getPlayer().getY()).getType().equals(CellType.OPEN_DOOR)) {
            currentMap += 1;
            setNextMap();
        }
    }

    private void setNextMap() {

        ArrayList inventory = map.getPlayer().getInventory();
        int health = map.getPlayer().getHealth();
        int strength = map.getPlayer().getStrength();
        this.map = MapLoader.loadMap(currentMap);
        map.getPlayer().setInventory(inventory);
        map.getPlayer().setHealth(health);
        map.getPlayer().setStrength(strength);
        refresh();
    }

    public Boolean isPlayerDead(Actor player) {
        return player.getHealth() <= 0;
    }

    private void setupDbManager() {
        dbManager = new GameDatabaseManager();
        try {
            dbManager.setup();
        } catch (SQLException ex) {
            System.out.println("Cannot connect to database.");
        }

    }

//    private List<String> addMapPaths() {
//        List<String> fileNames = new ArrayList<>();
//        fileNames.add("/map.txt");
//        fileNames.add("/map2.txt");
//        return fileNames;
//}
    private void exit() {
        try {
            stop();
        } catch (Exception e) {
            System.exit(1);
        }
        System.exit(0);
    }

    public Window createWindowForSavePopup() {
        Stage newStage = new Stage();
        VBox comp = new VBox();
        TextField nameField = new TextField("Name");
        comp.getChildren().add(nameField);
        Button cancel = new Button("Cancel");
        cancel.setOnAction((e) -> newStage.close());
        cancel.setCancelButton(true);
        cancel.setDefaultButton(true);
        Button saveToSqlBtn = new Button("Save");
        Button saveToFileBtn = new Button("Save to file");
        setupDbManager();
        saveToSqlBtn.setOnAction((e) -> {
            Timestamp time = new Timestamp(System.currentTimeMillis());
            String playerName = nameField.getText();
            map.getPlayer().setName(playerName);
            PlayerModel playerModel = new PlayerModel(map.getPlayer());
            if (dbManager.doesExist(playerName)) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Overwrite existing save");
                alert.setContentText("Would you like to overwrite the already existing state?");
                ButtonType btnType = alert.showAndWait().orElse(ButtonType.CANCEL);
                if (btnType == ButtonType.CANCEL) newStage.close();
                else {
                    dbManager.updatePlayer(playerModel);
                    dbManager.updateMap(currentMap, time, playerModel);
                    newStage.close();
                }
            } else {
                dbManager.savePlayer(playerModel);
                dbManager.saveMap(currentMap, time, playerModel);
                newStage.close();
            }
        });

        /* saveToFileBtn.setOnAction((e) -> {
            map.getPlayer().setName(nameField.getText());
            JSONObject gameState = map.getPlayer().serializeToJSON();
            gameState.addProperty("current_map", currentMap);
            Util.createSave(map.getPlayer().getName() + ".json", gameState);
            newStage.close();
        }); */

        comp.getChildren().add(cancel);
        comp.getChildren().add(saveToSqlBtn);
        comp.getChildren().add(saveToFileBtn);

        Scene stageScene = new Scene(comp, 300, 300);
        newStage.setScene(stageScene);
        newStage.show();
        return newStage;

    }
}


