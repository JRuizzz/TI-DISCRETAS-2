package com.example.animationsgame.model;

import com.example.animationsgame.HelloApplication;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class Map {
    private int id;
    private int[][] boundaries;
    private List<Bricks> obstacles;
    private int[] connections;


    public Map(int id, int[][] boundaries, int[] connections) {
        this.boundaries = boundaries;
        this.connections = connections;
        this.obstacles = new ArrayList<>();
        this.id = id;
        setObstacles();
    }

    private void setObstacles() {
        Image borderImage = new Image("file:" + HelloApplication.class.getResource("/barrier/brick.png").getPath());
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 30; j++) {
                double xPosition = (double) j * (1520.0 / 30.0);
                double yPosition = (double) i * (780.0 / 15.9);

                if (boundaries[i][j] == 2) {
                    obstacles.add(new Bricks(new Position(xPosition, yPosition), false, borderImage));
                } else if (boundaries[i][j] == 1) {
                    obstacles.add(new Bricks(new Position(xPosition, yPosition), true, borderImage));
                }
            }
        }
    }

    public List<Bricks> getObstacles() {
        return obstacles;
    }

    public void setObstacles(List<Bricks> obs) {
        this.obstacles = obs;
    }
}
