package com.example.animationsgame.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Grafo {
    private int[][] matrizAdyacencia;

    private int cantidadVertices;
    private List<Vertice> vertices;
    private List<Arista> edges;

    public Grafo() {
        cantidadVertices = 5; // Inicializar la cantidad de vértices en 0
        this.matrizAdyacencia = new int[cantidadVertices][cantidadVertices];
        inicializarMatrizAdyacencia();
        vertices = new ArrayList<>();
        edges = new ArrayList<>();
    }

    public Vertice agregarVertice(int id, int x, int y) {
        Vertice newVertex = new Vertice(id, x, y);
        vertices.add(newVertex);
        return newVertex;
    }

    public Arista agregarArista(Vertice v1, Vertice v2, int peso) {
        Arista newEdge = new Arista(v1, v2, peso);
        edges.add(newEdge);
        return newEdge;
    }

    public void removeVertex(Vertice v) {
        vertices.remove(v);
        edges.removeIf(e -> e.hasVertex(v));
    }

    public void removeEdge(Vertice e) {
        edges.remove(e);
    }

    public List<Vertice> getVertices() {
        return vertices;
    }

    public List<Arista> getEdges() {
        return edges;
    }

    public boolean hasConnection(Vertice v1, Vertice v2) {
        for (Arista e : edges) {
            if (e.hasVertex(v1) && e.hasVertex(v2)) {
                return true;
            }
        }
        return false;
    }

    public List<Position> dijkstra(Vertice inicio, Vertice fin) {
        // Arreglo para almacenar las distancias mínimas desde el vértice de inicio hasta los demás vértices
        int[] distancia = new int[cantidadVertices];

        // Arreglo para marcar los vértices que ya han sido visitados
        boolean[] visitado = new boolean[cantidadVertices];

        // Inicializar todas las distancias con un valor infinito, excepto la del vértice de inicio que es 0
        Arrays.fill(distancia, Integer.MAX_VALUE);
        distancia[inicio.getId()] = 0;

        // Arreglo para almacenar las posiciones de los vértices en el camino
        List<Position> camino = new ArrayList<>();

        // Iterar hasta que se visite el vértice final
        while (!visitado[fin.getId()]) {
            // Obtener el vértice con la menor distancia no visitado
            int verticeActual = obtenerVerticeConMenorDistancia(distancia, visitado);

            // Marcar el vértice actual como visitado
            visitado[verticeActual] = true;

            // Agregar la posición del vértice actual al camino
            camino.add(vertices.get(verticeActual).getPosicion());

            // Actualizar las distancias de los vértices adyacentes al vértice actual
            for (int vecino = 0; vecino < cantidadVertices; vecino++) {
                if (!visitado[vecino] && matrizAdyacencia[verticeActual][vecino] != 0
                        && distancia[verticeActual] != Integer.MAX_VALUE
                        && distancia[verticeActual] + matrizAdyacencia[verticeActual][vecino] < distancia[vecino]) {
                    distancia[vecino] = distancia[verticeActual] + matrizAdyacencia[verticeActual][vecino];
                }
            }
        }

        return camino;
    }

    private int obtenerVerticeConMenorDistancia(int[] distancia, boolean[] visitado) {
        int minimaDistancia = Integer.MAX_VALUE;
        int verticeMinimaDistancia = -1;

        // Iterar sobre todos los vértices
        for (int vertice = 0; vertice < cantidadVertices; vertice++) {
            // Verificar si el vértice no ha sido visitado y tiene una distancia menor a la mínima actual
            if (!visitado[vertice] && distancia[vertice] <= minimaDistancia) {
                // Actualizar la mínima distancia y el vértice correspondiente
                minimaDistancia = distancia[vertice];
                verticeMinimaDistancia = vertice;
            }
        }

        // Retornar el vértice con la menor distancia no visitado
        return verticeMinimaDistancia;
    }


    public void imprimirCamino(List<Position> camino) {
        System.out.println("Camino desde el inicio hasta el final:");
        for (Position posicion : camino) {
            System.out.println("la posicion es" +"["+posicion.getX()+"]" + "["+posicion.getY()+"]");
        }
    }

    private void inicializarMatrizAdyacencia() {
        for (int i = 0; i < cantidadVertices; i++) {
            for (int j = 0; j < cantidadVertices; j++) {
                // Inicializar todas las entradas en 0 o un valor que represente la ausencia de conexión
                matrizAdyacencia[i][j] = 0;
            }
        }
    }
}



