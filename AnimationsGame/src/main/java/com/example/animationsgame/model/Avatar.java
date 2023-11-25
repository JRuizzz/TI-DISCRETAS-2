package com.example.animationsgame.model;
import com.example.animationsgame.screens.ScreenA;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import com.example.animationsgame.model.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Avatar<T extends Position> {
    public static final String PATH_IDLE = "/animations/hero/idle/G";
    public static final String PATH_RIGHT = "/animations/hero/right/right";
    public static final String PATH_LEFT = "/animations/hero/left/left";
    public static final String PATH_UP = "/animations/hero/up/up";

    public static final String PATH_DOWN = "/animations/hero/down/down";

    private final int width;
    private final int height;

    //Elementos graficos
    private Canvas canvas;
    private GraphicsContext graphicsContext;
    private ArrayList<Image> idles;
    private ArrayList<Image> right;

    private ArrayList<Image> left;

    private ArrayList<Image> up;

    private ArrayList<Image> down;

    private boolean rightPressed;

    private boolean leftPressed;

    private boolean upPressed;

    private boolean downPressed;

    private int frame;

    //Elementos espaciales

    private Position position;

    private State state;
    private double previousX;
    private double previousY;


    public Avatar(Canvas canvas) {
        this.canvas = canvas;
        this.graphicsContext = this.canvas.getGraphicsContext2D();
        this.width = 50;
        this.height = 50;
        this.state = State.IDLE;

        this.frame = 0;

        this.idles = new ArrayList<>();
        this.right = new ArrayList<>();
        this.left = new ArrayList<>();
        this.up = new ArrayList<>();
        this.down = new ArrayList<>();

        this.position = new Position(400, 300);

        this.previousX = position.getX();
        this.previousY = position.getY();

        for (int i = 1; i <= 4; i++) {
            Image image = new Image(getClass().getResourceAsStream(PATH_IDLE + i + ".png"), 80, 80, false, false);
            this.idles.add(image);
        }
        for (int i = 1; i <= 12; i++) {
            Image image = new Image(getClass().getResourceAsStream(PATH_RIGHT + i + ".png"), 80, 80, false, false);
            this.right.add(image);
        }
        for (int i = 1; i <= 12; i++) {
            Image image = new Image(getClass().getResourceAsStream(PATH_LEFT + i + ".png"), 80, 80, false, false);
            this.left.add(image);
        }
        for (int i = 1; i <= 12; i++) {
            Image image = new Image(getClass().getResourceAsStream(PATH_DOWN + i + ".png"), 80, 80, false, false);
            this.down.add(image);
        }
        for (int i = 1; i <= 12; i++) {
            Image image = new Image(getClass().getResourceAsStream(PATH_UP + i + ".png"), 80, 80, false, false);
            this.up.add(image);
        }
    }


    public void paint() {
        graphicsContext.drawImage(idles.get(frame % 4), position.getX(), position.getY());
        frame++;
    }

    public void moverEnCaminoMasCorto(List<Position> caminoMasCorto) {
        if (caminoMasCorto != null && !caminoMasCorto.isEmpty()) {
            Position siguientePaso = caminoMasCorto.remove(0);
            position.setX(siguientePaso.getX());
            position.setY(siguientePaso.getY());
        }
    }



    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public double getPreviousX() {
        return previousX;
    }

    public double getPreviousY() {
        return previousY;
    }

}