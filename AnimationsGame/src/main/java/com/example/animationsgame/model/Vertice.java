package com.example.animationsgame.model;

public class Vertice {
    private int id;
    private Position posicion;

    public Vertice(int id, int x, int y) {
        this.id = id;
        this.posicion = new Position(x, y);
    }

    public int getId() {
        return id;
    }


    public Position getPosicion() {
        return posicion;
    }
}