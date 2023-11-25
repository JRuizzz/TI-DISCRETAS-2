package com.example.animationsgame.model;

public class Arista<V extends Vertice> {
    private V v1;
    private V v2;
    private int peso;

    public Arista(V v1, V v2, int peso) {
        this.v1 = v1;
        this.v2 = v2;
        this.peso = peso;
    }

    public boolean hasVertex(V vertex) {
        return v1 == vertex || v2 == vertex;
    }

    public V getOtherVertex(V vertex) {
        if (vertex == v1) {
            return v2;
        } else if (vertex == v2) {
            return v1;
        } else {
            return null;
        }
    }

    public V getOtroExtremo(V vertex) {
        return getOtherVertex(vertex);
    }

    public int getPeso() {
        return peso;
    }
}
