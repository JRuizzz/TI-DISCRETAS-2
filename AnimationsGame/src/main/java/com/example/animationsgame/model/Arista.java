package com.example.animationsgame.model;

public class Arista {
    private Vertice v1;
    private Vertice v2;
    private int peso;

    public Arista(Vertice v1, Vertice v2, int peso) {
        this.v1 = v1;
        this.v2 = v2;
        this.peso = peso;
    }

    public Vertice getOtroVertice(Vertice vertice) {
        if (vertice.equals(v1)) {
            return v2;
        } else if (vertice.equals(v2)) {
            return v1;
        } else {
            // Manejar el caso en el que el vértice no pertenece a la arista
            throw new IllegalArgumentException("El vértice no pertenece a esta arista.");
        }
    }

    public boolean hasVertex(Vertice vertice) {
        return vertice.equals(v1) || vertice.equals(v2);
    }

    public int getPeso() {
        return peso;
    }

    public Vertice getV1() {
        return v1;
    }

    public Vertice getV2() {
        return v2;
    }
}
