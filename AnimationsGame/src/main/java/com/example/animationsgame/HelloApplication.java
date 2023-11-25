package com.example.animationsgame;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        openWindow("mainMenu.fxml");
    }
    public static File getFile(String fileName) {
        return new File(Objects.requireNonNull(HelloApplication.class.getResource(fileName)).getPath());
    }

    public static void openWindow(String path) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(path));
            Scene scene = new Scene(fxmlLoader.load(),1520 ,770);
            Stage stage = new Stage();
            stage.setTitle("GRAPH BALL Z");
            String uri = HelloApplication.class.getResource("/cursorAlien/CursorAlien.png").toExternalForm();
            Cursor cursor = Cursor.cursor(uri);
            scene.setCursor(cursor);
            stage.setScene(scene);
            stage.show();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }

    }
