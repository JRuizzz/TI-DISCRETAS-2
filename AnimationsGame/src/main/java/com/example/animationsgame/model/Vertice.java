package com.example.animationsgame.model;

public class Vertice {
    private int id;
    private Position posicion;

    private int x;
    private int y;

    public Vertice(int id, int x, int y) {
        this.id = id;
        this.posicion = new Position(x, y);
    }

    public int getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Position getPosicion() {
        return posicion;
    }
}