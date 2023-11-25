package com.example.animationsgame.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Bricks extends Drawing{

    private Image brickImage;
    private boolean isDestructible;
    private int durability;
    public Bricks(Position position, boolean isDestructible,Image brickImage){
        this.isDestructible = isDestructible;
        this.width = 50;
        this.heigh = 50;
        this.position = position;
        this.brickImage = brickImage;
        durability = 5;
    }
    public int getWidth(){
        return this.width;
    }
    public int getHeight(){
        return this.heigh;
    }
    @Override
    public void draw(GraphicsContext gc) {
        gc.drawImage(brickImage,position.getX(),position.getY(),50,50);
    }
    public void setDurability(int n){
        if(isDestructible){
            this.durability = n;
        }
    }
    public int getDurability(){return this.durability;}
}
