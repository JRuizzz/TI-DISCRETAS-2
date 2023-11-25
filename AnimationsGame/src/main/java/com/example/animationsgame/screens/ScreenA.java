package com.example.animationsgame.screens;

import com.example.animationsgame.model.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ScreenA {
    private Canvas canvas;
    private GraphicsContext graphicsContext;
    private Avatar avatar;
    private int currentMap;
    private ArrayList<Map> maps;

    //private Avatar avatar; Parece que no es necesario.
    private Grafo grafo;
    private List<Position> caminoMasCorto;

    public ScreenA(Canvas canvas) {
        this.canvas = canvas;
        this.graphicsContext = this.canvas.getGraphicsContext2D();

        this.avatar = new Avatar(this.canvas);

        this.currentMap = 1; // Puedes cambiar esto según tu lógica de cambio de mapas
        this.maps = new ArrayList<>();
        initializeMaps();

        this.grafo = new Grafo();
        this.caminoMasCorto = inicializarGrafo();

    }

    private void initializeMaps() {
        int[][] map1Boundaries = new PositionBarrier().map1Barrier();
        int[] map1Connections = {2}; // Por ejemplo, este mapa tiene una conexión al mapa 2
        Map map1 = new Map(1, map1Boundaries, map1Connections);
        maps.add(map1);
    }

    public void paint() {
        graphicsContext.setFill(Color.LIGHTGOLDENRODYELLOW);
        graphicsContext.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        drawMapObstacles();
        avatar.paint();
        //avatar.moverEnCaminoMasCorto(caminoMasCorto);  // Corregido aquí
    }


    private void drawMapObstacles() {
        Map currentMap = maps.get(this.currentMap - 1); // Restamos 1 porque los índices de listas comienzan desde 0
        List<Bricks> obstacles = currentMap.getObstacles();

        for (Bricks obstacle : obstacles) {
            obstacle.draw(graphicsContext);
        }
    }

    private List<Position>  inicializarGrafo() {
        // Crear una instancia de la clase Grafo
        Grafo grafo = new Grafo();

        // Agregar vértices
        Vertice v0 = grafo.agregarVertice(0, 100, 100);
        Vertice v1 = grafo.agregarVertice(1, 200, 200);
        Vertice v2 = grafo.agregarVertice(2, 300, 300);
        Vertice v3 = grafo.agregarVertice(3, 400, 400);
        Vertice v4 = grafo.agregarVertice(4, 500, 500);

        // Establecer conexiones para cada vértice
        grafo.agregarArista(v0, v1, 1);
        grafo.agregarArista(v1, v0, 1);
        grafo.agregarArista(v0, v2, 2);
        grafo.agregarArista(v2, v0, 2);
        grafo.agregarArista(v1, v3, 3);
        grafo.agregarArista(v3, v1, 3);
        grafo.agregarArista(v2, v3, 1);
        grafo.agregarArista(v3, v4, 1); // Corregí la conexión duplicada a v3 y agregué una conexión a v4

        Vertice inicio = v0;
        Vertice fin = v3;

        // Calcular el camino más corto usando el algoritmo de Dijkstra
        List<Position> camino = grafo.dijkstra(inicio, fin);

        return camino;
        // Imprimir el camino
       // grafo.imprimirCamino(camino);
    }

    public void onKeyPressed(KeyEvent event) {
        avatar.onKeyPressed(event);
    }

    public void onKeyReleased(KeyEvent event) {
        avatar.onKeyReleased(event);
    }
}
