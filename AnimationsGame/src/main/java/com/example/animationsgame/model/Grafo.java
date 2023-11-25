package com.example.animationsgame.model;
import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;


public class Grafo {
    private int[][] matrizAdyacencia;

    private int cantidadVertices;
    private List<Vertice> vertices;
    private List<Arista> edges;



    public Grafo() {
        cantidadVertices = 5; // Inicializar la cantidad de vértices en 0
        this.matrizAdyacencia = new int[cantidadVertices][cantidadVertices];
        vertices = new ArrayList<>();
        edges = new ArrayList<>();
    }

    public Vertice agregarVertice(int id, int x, int y) {
        Vertice newVertex = new Vertice(id, x, y);
        vertices.add(newVertex);
        return newVertex;
    }

    public Arista agregarArista(Vertice v1, Vertice v2, int peso) {
        if(peso<0){
            return null;
        } else if (v2==null || v1==null){
            return null;
        }
        Arista newEdge = new Arista(v1, v2, peso);
        edges.add(newEdge);
        return newEdge;
    }


    // ---------------------------------------------------------------------------------------------------//
    public List<Position> dijkstra(Vertice inicio, Vertice fin) {
        // Inicializar distancias y visitados
        Integer[] distancia = new Integer[cantidadVertices];
        boolean[] visitado = new boolean[cantidadVertices];
        Arrays.fill(distancia, Integer.MAX_VALUE);

        // Mapa para almacenar el camino más corto hasta cada vértice
        Map<Vertice, Vertice> caminoMasCorto = new HashMap<>();

        // Inicializar la distancia del vértice de inicio como 0
        distancia[inicio.getId()] = 0;

        // Cola de prioridad para almacenar vértices ordenados por distancia
        PriorityQueue<Vertice> colaPrioridad = new PriorityQueue<>(Comparator.comparingInt(vertice -> distancia[vertice.getId()]));

        // Agregar el vértice de inicio a la cola
        colaPrioridad.offer(inicio);

        while (!colaPrioridad.isEmpty()) {
            Vertice actual = colaPrioridad.poll();

            if (visitado[actual.getId()]) {
                continue;
            }

            visitado[actual.getId()] = true;

            for (Arista arista : edges) {
                if (arista.hasVertex(actual)) {
                    Vertice vecino = arista.getOtroVertice(actual);
                    int nuevaDistancia = distancia[actual.getId()] + arista.getPeso();

                    if (nuevaDistancia < distancia[vecino.getId()]) {
                        distancia[vecino.getId()] = nuevaDistancia;
                        caminoMasCorto.put(vecino, actual);
                        colaPrioridad.offer(vecino);
                    }
                }
            }
        }

        // Reconstruir el camino desde el vértice de fin hasta el inicio
        List<Position> camino = new ArrayList<>();
        Vertice actual = fin;
        while (actual != null) {
            camino.add(actual.getPosicion());
            actual = caminoMasCorto.get(actual);
        }

        // Invertir el camino para que esté en el orden correcto
        Collections.reverse(camino);

        return camino;
    }

    // ---------------------------------------------------------------------------------------------------//
    public List<Position> floydWarshall(Vertice inicio, Vertice fin) {
        int n = cantidadVertices;

        // Inicializar la matriz de distancias con los pesos de las aristas
        int[][] distancias = new int[n][n];
        int[][] intermedios = new int[n][n]; // Matriz para almacenar vértices intermedios en el camino

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                distancias[i][j] = matrizAdyacencia[i][j];
                intermedios[i][j] = j; // Inicializar los vértices intermedios como los destinos directos
            }
        }

        // Calcular los caminos más cortos entre todos los pares de vértices
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (distancias[i][k] != Integer.MAX_VALUE && distancias[k][j] != Integer.MAX_VALUE
                            && distancias[i][k] + distancias[k][j] < distancias[i][j]) {
                        distancias[i][j] = distancias[i][k] + distancias[k][j];
                        intermedios[i][j] = intermedios[i][k]; // Actualizar el vértice intermedio
                    }
                }
            }
        }

        // Reconstruir el camino desde el inicio hasta el fin
        List<Position> camino = new ArrayList<>();
        int verticeActual = inicio.getId(); // Comenzar desde el vértice de inicio

        while (verticeActual != fin.getId()) {
            camino.add(vertices.get(fin.getId()).getPosicion());

            // Mover al siguiente vértice en el camino más corto
            verticeActual = intermedios[verticeActual][fin.getId()];
        }

        return camino;
    }


    // ---------------------------------------------------------------------------------------------------//
    public void imprimirCamino(List<Position> camino) {
        System.out.println("Camino desde el inicio hasta el final:");
        for (Position posicion : camino) {
            System.out.println("la posicion es" +"["+posicion.getX()+"]" + "["+posicion.getY()+"]");
        }
    }


    public int getCantidadVertices() {
        return cantidadVertices;
    }

    public List<Vertice> getVertices() {
        return vertices;
    }

    public List<Arista> getEdges() {
        return edges;
    }
}



