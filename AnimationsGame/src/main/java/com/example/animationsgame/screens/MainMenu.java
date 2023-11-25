package com.example.animationsgame.screens;

import com.example.animationsgame.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MainMenu implements Initializable {
    @FXML
    public Label exitBT;
    @FXML
    private GraphicsContext gc;
    @FXML
    public Canvas canvas;


    @FXML
    private Label playBT;

    @FXML
    void displayScores(MouseEvent event) {

    }

    @FXML
    void playGame(MouseEvent event) {
        HelloApplication.openWindow("hello-view.fxml");
        Stage stage = (Stage) playBT.getScene().getWindow();
        stage.close();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image image = new Image("file:"+ HelloApplication.class.getResource("MenuPrincipal Image/Menu1.png").getPath());
        gc = canvas.getGraphicsContext2D();
        canvas.setFocusTraversable(true);
        gc.drawImage(image,0,0,canvas.getWidth(),canvas.getHeight());
    }
    @FXML
    public void mouseEnteredPlay(MouseEvent mouseEvent) {
        playBT.setTextFill(Color.WHITE);
    }

    @FXML
    public void mouseExitedPlay(MouseEvent mouseEvent) {
        playBT.setTextFill(Color.PURPLE);
    }
    @FXML
    public void exitProgram(MouseEvent mouseEvent) {
        System.exit(0);
    }
    @FXML
    public void mouseExitedExit(MouseEvent mouseEvent) {
        exitBT.setTextFill(Color.PURPLE);
    }
    @FXML
    public void mouseEnteredExit(MouseEvent mouseEvent) {
        exitBT.setTextFill(Color.WHITE);
    }

}

