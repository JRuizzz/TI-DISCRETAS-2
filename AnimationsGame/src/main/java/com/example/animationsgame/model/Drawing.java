
package com.example.animationsgame.model;

import javafx.scene.canvas.GraphicsContext;

public abstract class Drawing {
    public Position position = new Position(0,0);
    protected int width;
    protected int heigh;
    public abstract void draw(GraphicsContext gc);

}
