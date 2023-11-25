package com.example.animationsgame.model;
import com.example.animationsgame.HelloApplication;
import javafx.scene.image.Image;


import com.example.animationsgame.HelloApplication;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import java.util.ArrayList;

public class Map {
    private int id;
    private int[][] boundaries;
    private ArrayList<Bricks> blocks;
    private int[] connections;
    public Map(int id, int[][] boundaries, int[] connections) {
        this.boundaries = boundaries;
        this.connections = connections;
        blocks = new ArrayList<>();
        this.id = id;
        setObstacles();
    }

    public void setObstacles() {
        Image borderImage = new Image("file:" + HelloApplication.class.getResource("barrier/brick.png").getPath());
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 30; j++) {
                double xPosition = (double) j * (1520.0 / 30.0);
                double yPosition = (double) i * (780.0 / 16);

                if (boundaries[i][j] == 2){
                    blocks.add(new Bricks(new Position(xPosition, yPosition), false, borderImage));
                }else if (boundaries[i][j] == 1) {
                    blocks.add(new Bricks(new Position(xPosition, yPosition), true, borderImage));
                }
            }
        }
    }



    public ArrayList<Bricks> getBlocks(){return blocks;}
    public void setObstacles(ArrayList<Bricks> blocks){this.blocks = blocks;}

    public int[] getConnections() {
        return connections;
    }

    public void setConnections(int[] connections) {
        this.connections = connections;
    }



}
