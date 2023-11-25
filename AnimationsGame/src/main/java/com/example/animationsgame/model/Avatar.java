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
    public static final String PATH_IDLE="/animations/hero/idle/idle";
    public static final String PATH_RIGHT="/animations/hero/right/right";
    public static final String PATH_LEFT="/animations/hero/left/left";
    public static final String PATH_UP="/animations/hero/up/up";

    public static final String PATH_DOWN="/animations/hero/down/down";

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

    private  boolean leftPressed;

    private boolean upPressed;

    private boolean downPressed;

    private int frame;

    //Elementos espaciales

    private Position position;

    private State state;

    private int pasoActual;
    private static final double MOVEMENT_SPEED = 10.0;
    private List<Position> caminoMasCorto; // Lista de coordenadas en el camino más corto



    public Avatar(Canvas canvas) {
        this.canvas = canvas;
        this.graphicsContext = this.canvas.getGraphicsContext2D();
        this.width = 80;
        this.height = 80;
        this.state = State.IDLE;

        this.frame = 0;

        this.idles = new ArrayList<>();
        this.right = new ArrayList<>();
        this.left = new ArrayList<>();
        this.up = new ArrayList<>();
        this.down = new ArrayList<>();

        this.position = new Position(100, 100);

        for (int i = 1; i <= 9; i++) {
            Image image = new Image(getClass().getResourceAsStream(PATH_IDLE+ i + ".png"),80,80,false,false);
            this.idles.add(image);
        }
    }


    public void paint() {
        onMove();
        if (state == State.IDLE) {
            graphicsContext.drawImage(idles.get(frame % 9), position.getX(), position.getY());
            frame++;
        }
    }
    public void moverEnCaminoMasCorto(List<Position> caminoMasCorto) {
        if (caminoMasCorto != null && !caminoMasCorto.isEmpty()) {
            Position siguientePaso = caminoMasCorto.remove(0);
            position.setX(siguientePaso.getX());
            position.setY(siguientePaso.getY());
        }
    }
    public void onKeyPressed(KeyEvent event) {
        switch (event.getCode()) {
            case D -> {
                state = State.IDLE;
                rightPressed = true;
            }
            case A -> {
                state = State.IDLE;
                leftPressed = true;
            }
            case S -> {
                state = State.IDLE;
                downPressed = true;
            }
            case W -> {
                state = State.IDLE;
                upPressed = true;
            }
        }
    }

    public void onKeyReleased(KeyEvent event) {
        switch (event.getCode()) {
            case D -> {
                state = State.IDLE;
                rightPressed = false;
            }
            case A-> {
                state = State.IDLE;
                leftPressed = false;
            }
            case S -> {
                state = State.IDLE;
                downPressed = false;
            }
            case W-> {
                state = State.IDLE;
                upPressed = false;
            }
        }
    }
    public void onMove() {
        if (rightPressed) {
            position.setX(position.getX() + 5);
        }

        if (leftPressed) {
            position.setX(position.getX() - 5);
        }

        if (upPressed) {
            position.setY(position.getY() - 5);
        }

        if (downPressed) {
            position.setY(position.getY() + 5);
        }
        // Imprimir la posición en la consola
        System.out.println("Posición actual del avatar: X = " + position.getX() + ", Y = " + position.getY());
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
}