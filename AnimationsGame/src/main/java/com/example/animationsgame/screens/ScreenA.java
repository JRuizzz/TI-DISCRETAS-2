package com.example.animationsgame.screens;

import com.example.animationsgame.HelloApplication;
import com.example.animationsgame.model.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.animation.PauseTransition;
import javafx.util.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ScreenA {
    private Canvas canvas;
    private GraphicsContext graphicsContext;
    private Avatar avatar;
    private int currentMap;
    private ArrayList<Map> maps;
    private List<Position> caminoMasCorto;
    private List<Position> caminoMasCorto1;
    private List<Position> caminoMasCorto2;
    private List<Position> caminoMasCorto3;

    private List<Position> caminoMasCorto4;

    private Image image;
    public ScreenA(Canvas canvas) {
        this.canvas = canvas;
        this.graphicsContext = this.canvas.getGraphicsContext2D();

        this.avatar = new Avatar(this.canvas);
        String url = "file:" + HelloApplication.class.getResource("backgrounds/img.png").getPath();
        image = new Image(url);
        currentMap = 0;
        setMaps();
        this.caminoMasCorto = inicializarGrafoMapa1();
        this.caminoMasCorto1 = inicializarGrafoMapa2();
        this.caminoMasCorto2 = inicializarGrafoMapa3();
        this.caminoMasCorto3 = inicializarGrafoMapa4();
        this.caminoMasCorto4 = inicializarGrafoMapa5();

    }

    private void drawBackground() {
        if(currentMap == 0){
            avatar.moverEnCaminoMasCorto(caminoMasCorto);
            graphicsContext.drawImage(new Image("file:" + HelloApplication.class.getResource("backgrounds/1.png").getPath()), 0, 0, canvas.getWidth(), canvas.getHeight());
        } else if (currentMap == 1) {
            avatar.moverEnCaminoMasCorto(caminoMasCorto1);
            graphicsContext.drawImage(new Image("file:" + HelloApplication.class.getResource("backgrounds/2.png").getPath()), 0, 0, canvas.getWidth(), canvas.getHeight());
        } else if (currentMap == 2) {
            avatar.moverEnCaminoMasCorto(caminoMasCorto2);
            graphicsContext.drawImage(new Image("file:" + HelloApplication.class.getResource("backgrounds/3.png").getPath()), 0, 0, canvas.getWidth(), canvas.getHeight());
        } else if (currentMap == 3) {
            avatar.moverEnCaminoMasCorto(caminoMasCorto3);
            graphicsContext.drawImage(new Image("file:" + HelloApplication.class.getResource("backgrounds/4.png").getPath()), 0, 0, canvas.getWidth(), canvas.getHeight());
        } else if (currentMap == 4) {
            avatar.moverEnCaminoMasCorto(caminoMasCorto4);
            graphicsContext.drawImage(new Image("file:" + HelloApplication.class.getResource("backgrounds/5.png").getPath()), 0, 0, canvas.getWidth(), canvas.getHeight());
        }
    }
    public void paint() {
        AvatarCollideWithObstacles();
        AvatarCollideWithMapBoundary();
        drawBackground();
        drawMapObstacles();
        avatar.paint();
    }


    private void AvatarCollideWithMapBoundary() {
        double avatarX = avatar.getPosition().getX();
        double avatarY = avatar.getPosition().getY();
        double avatarWidth = avatar.getWidth();
        double avatarHeight = avatar.getHeight();

        double difSup = Math.abs(0 - avatarY);
        double difInf = (canvas.getHeight() - (avatarY + avatarHeight));
        double difRight = Math.abs(canvas.getWidth() - (avatarX + avatarWidth));
        double difLeft = Math.abs(0 - avatarX);

        if (difSup < 5) {
            avatar.getPosition().setY(canvas.getHeight() - avatarHeight - 10);
            currentMap = maps.get(currentMap).getConnections()[0];
        } else if (difInf < 5) {
            // Acciones para la conexión en la dirección inferior
            avatar.getPosition().setY(10);
            currentMap = maps.get(currentMap).getConnections()[1];
        } else if (difRight < 5) {
            // Acciones para la conexión en la dirección derecha
            avatar.getPosition().setX(25 + avatarWidth);
            currentMap = maps.get(currentMap).getConnections()[2];
        } else if (difLeft < 5) {
            // Acciones para la conexión en la dirección izquierda
            avatar.getPosition().setX(canvas.getWidth() - (avatarWidth + 25));
            currentMap = maps.get(currentMap).getConnections()[3];
        }

        if (avatarX == 735 && avatarY == 679) {
            PauseTransition pause = new PauseTransition(Duration.seconds(5));
            pause.setOnFinished(event -> {
                performActionAtVertex9();
            });
            pause.play();
        }
    }


    private void performActionAtVertex9() {
        // Realizar la acción específica cuando se encuentra en el vértice número 9
        // Por ejemplo, mover 20 unidades hacia abajo
        avatar.getPosition().setY(avatar.getPosition().getY() + 60);
    }


    private void drawMapObstacles() {
        Map map = maps.get(currentMap);
        for (int i = 0; i < map.getBlocks().size(); i++) {
            Bricks o = map.getBlocks().get(i);
            o.draw(graphicsContext);
            AvatarObstacleCollition(o);
        }
    }

    private List<Position> inicializarGrafoMapa1() {
        Grafo grafo1 = new Grafo();
        Vertice v0 = grafo1.agregarVertice(0, 200, 50);
        Vertice v1 = grafo1.agregarVertice(1, 735, 60);
        Vertice v2 = grafo1.agregarVertice(2, 1215, 60);
        Vertice v3 = grafo1.agregarVertice(3, 1220, 515);
        Vertice v4 = grafo1.agregarVertice(4, 425, 250);
        Vertice v5 = grafo1.agregarVertice(5, 1050, 250);
        Vertice v6 = grafo1.agregarVertice(6, 200, 510);
        Vertice v7 = grafo1.agregarVertice(7, 735, 465);
        Vertice v8= grafo1.agregarVertice(8, 735, 255);
        Vertice v9= grafo1.agregarVertice(9, 735, 685);


        // Establecer conexiones para cada vértice
        grafo1.agregarArista(v0, v1, 3);
        grafo1.agregarArista(v0, v6, 2);
        grafo1.agregarArista(v1, v0, 3);
        grafo1.agregarArista(v1, v2, 1);
        grafo1.agregarArista(v2, v1, 1);
        grafo1.agregarArista(v2, v3, 9);
        grafo1.agregarArista(v3, v2, 9);
        grafo1.agregarArista(v3, v7, 8);
        grafo1.agregarArista(v3, v9, 6);
        grafo1.agregarArista(v3, v7, 8);
        grafo1.agregarArista(v4, v8, 4);
        grafo1.agregarArista(v4, v6, 6);
        grafo1.agregarArista(v4, v9, 5);
        grafo1.agregarArista(v5, v8, 2);
        grafo1.agregarArista(v5, v7, 7);
        grafo1.agregarArista(v6, v4, 6);
        grafo1.agregarArista(v6, v0, 2);
        grafo1.agregarArista(v7, v5, 7);
        grafo1.agregarArista(v7, v3, 8);
        grafo1.agregarArista(v8, v4, 4);
        grafo1.agregarArista(v8, v5, 2);
        grafo1.agregarArista(v9, v4, 5);
        grafo1.agregarArista(v9, v3, 6);


        Vertice inicio = v0;
        Vertice fin = v9;

        List<Position> camino = grafo1.dijkstra(inicio, fin);

        return camino;

    }

    private List<Position> inicializarGrafoMapa2() {
        Grafo grafo2 = new Grafo();
        Vertice v0 = grafo2.agregarVertice(0, 200, 50);
        Vertice v1 = grafo2.agregarVertice(1, 735, 60);
        Vertice v2 = grafo2.agregarVertice(2, 1215, 60);
        Vertice v3 = grafo2.agregarVertice(3, 1220, 515);
        Vertice v4 = grafo2.agregarVertice(4, 425, 250);
        Vertice v5 = grafo2.agregarVertice(5, 1050, 250);
        Vertice v6 = grafo2.agregarVertice(6, 200, 510);
        Vertice v7 = grafo2.agregarVertice(7, 735, 465);
        Vertice v8= grafo2.agregarVertice(8, 735, 255);
        Vertice v9= grafo2.agregarVertice(9, 735, 685);


        // Establecer conexiones para cada vértice
        grafo2.agregarArista(v0, v1, 5);
        grafo2.agregarArista(v0, v4, 1);
        grafo2.agregarArista(v0, v6, 3);
        grafo2.agregarArista(v1, v0, 5);
        grafo2.agregarArista(v1, v2, 2);
        grafo2.agregarArista(v2, v1, 2);
        grafo2.agregarArista(v2, v3, 1);
        grafo2.agregarArista(v3, v2, 1);
        grafo2.agregarArista(v3, v7, 9);
        grafo2.agregarArista(v3, v9, 8);
        grafo2.agregarArista(v4, v8, 7);
        grafo2.agregarArista(v4, v0, 1);
        grafo2.agregarArista(v4, v6, 6);
        grafo2.agregarArista(v4, v9, 5);
        grafo2.agregarArista(v5, v8, 4);
        grafo2.agregarArista(v5, v7, 2);
        grafo2.agregarArista(v6, v4, 6);
        grafo2.agregarArista(v6, v9, 5);
        grafo2.agregarArista(v6, v0, 3);
        grafo2.agregarArista(v7, v5, 2);
        grafo2.agregarArista(v7, v3, 9);
        grafo2.agregarArista(v7, v9, 2);
        grafo2.agregarArista(v8, v5, 4);
        grafo2.agregarArista(v8, v4, 7);
        grafo2.agregarArista(v9, v3, 8);
        grafo2.agregarArista(v9, v7, 2);
        grafo2.agregarArista(v9, v4, 5);
        grafo2.agregarArista(v9, v6, 5);




        Vertice inicio = v0;
        Vertice fin = v9;

        List<Position> camino1 = grafo2.dijkstra(inicio, fin);

        return camino1;

    }


    private List<Position> inicializarGrafoMapa3() {
        Grafo grafo = new Grafo();

        Vertice v0 = grafo.agregarVertice(0, 200, 50);
        Vertice v1 = grafo.agregarVertice(1, 735, 60);
        Vertice v2 = grafo.agregarVertice(2, 1215, 60);
        Vertice v3 = grafo.agregarVertice(3, 1220, 515);
        Vertice v4 = grafo.agregarVertice(4, 425, 250);
        Vertice v5 = grafo.agregarVertice(5, 1050, 250);
        Vertice v6 = grafo.agregarVertice(6, 200, 510);
        Vertice v7 = grafo.agregarVertice(7, 735, 465);
        Vertice v8= grafo.agregarVertice(8, 735, 255);
        Vertice v9= grafo.agregarVertice(9, 735, 685);


        // Establecer conexiones para cada vértice
        grafo.agregarArista(v0, v1, 5);
        grafo.agregarArista(v0, v4, 1);
        grafo.agregarArista(v0, v6, 3);

        grafo.agregarArista(v1, v0, 5);
        grafo.agregarArista(v1, v2, 2);

        grafo.agregarArista(v2, v1, 2);
        grafo.agregarArista(v2, v5, 9);
        grafo.agregarArista(v2, v3, 1);

        grafo.agregarArista(v3, v2, 1);
        grafo.agregarArista(v3, v7, 9);
        grafo.agregarArista(v3, v9, 8);

        grafo.agregarArista(v4, v0, 1);
        grafo.agregarArista(v4, v8, 7);
        grafo.agregarArista(v4, v9, 5);
        grafo.agregarArista(v4, v6, 6);

        grafo.agregarArista(v5, v2, 9);
        grafo.agregarArista(v5, v7, 2);
        grafo.agregarArista(v5, v8, 4);

        grafo.agregarArista(v6, v0, 3);
        grafo.agregarArista(v6, v4, 6);
        grafo.agregarArista(v6, v9, 5);

        grafo.agregarArista(v7, v8, 6);
        grafo.agregarArista(v7, v5, 2);
        grafo.agregarArista(v7, v9, 2);
        grafo.agregarArista(v7, v3, 9);

        grafo.agregarArista(v8, v1, 3);
        grafo.agregarArista(v8, v5, 4);
        grafo.agregarArista(v8, v7, 6);
        grafo.agregarArista(v8, v4, 7);

        grafo.agregarArista(v9, v3, 8);
        grafo.agregarArista(v9, v7, 2);
        grafo.agregarArista(v9, v6, 5);
        grafo.agregarArista(v9, v4, 5);


        Vertice inicio = v0;
        Vertice fin = v9;

        List<Position> camino = grafo.dijkstra(inicio, fin);

        return camino;

    }

    private List<Position> inicializarGrafoMapa4() {
        Grafo grafo = new Grafo();

        Vertice v0 = grafo.agregarVertice(0, 200, 50);
        Vertice v1 = grafo.agregarVertice(1, 735, 60);
        Vertice v2 = grafo.agregarVertice(2, 1215, 60);
        Vertice v3 = grafo.agregarVertice(3, 1220, 515);
        Vertice v4 = grafo.agregarVertice(4, 425, 250);
        Vertice v5 = grafo.agregarVertice(5, 1050, 250);
        Vertice v6 = grafo.agregarVertice(6, 200, 510);
        Vertice v7 = grafo.agregarVertice(7, 735, 465);
        Vertice v8= grafo.agregarVertice(8, 735, 255);
        Vertice v9= grafo.agregarVertice(9, 735, 685);


        // Establecer conexiones para cada vértice
        grafo.agregarArista(v0, v1, 3);
        grafo.agregarArista(v0, v4, 1);

        grafo.agregarArista(v1, v8, 3);

        grafo.agregarArista(v2, v1, 5);
        grafo.agregarArista(v2, v5, 7);
        grafo.agregarArista(v2, v3, 2);

        grafo.agregarArista(v3, v9, 8);

        grafo.agregarArista(v4, v9, 7);
        grafo.agregarArista(v4, v6, 1);

        grafo.agregarArista(v5, v7, 2);

        grafo.agregarArista(v6, v4, 1);
        grafo.agregarArista(v6, v9, 9);
        grafo.agregarArista(v6, v0, 8);

        grafo.agregarArista(v7, v9, 2);
        grafo.agregarArista(v7, v5, 2);
        grafo.agregarArista(v7, v3, 9);


        grafo.agregarArista(v8, v5, 8);
        grafo.agregarArista(v8, v7, 6);
        grafo.agregarArista(v8, v4, 9);

        Vertice inicio = v0;
        Vertice fin = v9;

        List<Position> camino = grafo.dijkstra(inicio, fin);

        return camino;

    }
    private List<Position> inicializarGrafoMapa5() {
        Grafo grafo = new Grafo();

        Vertice v0 = grafo.agregarVertice(0, 200, 50);
        Vertice v1 = grafo.agregarVertice(1, 735, 60);
        Vertice v2 = grafo.agregarVertice(2, 1215, 60);
        Vertice v3 = grafo.agregarVertice(3, 1220, 515);
        Vertice v4 = grafo.agregarVertice(4, 425, 250);
        Vertice v5 = grafo.agregarVertice(5, 1050, 250);
        Vertice v6 = grafo.agregarVertice(6, 200, 510);
        Vertice v7 = grafo.agregarVertice(7, 735, 465);
        Vertice v8= grafo.agregarVertice(8, 735, 255);
        Vertice v9= grafo.agregarVertice(9, 735, 685);


        // Establecer conexiones para cada vértice
        grafo.agregarArista(v0, v1, 15);
        grafo.agregarArista(v0, v4, 11);

        grafo.agregarArista(v1, v8, 21);

        grafo.agregarArista(v2, v1, 22);
        grafo.agregarArista(v2, v5, 19);
        grafo.agregarArista(v2, v3, 21);

        grafo.agregarArista(v3, v9, 18);

        grafo.agregarArista(v4, v9, 15);
        grafo.agregarArista(v4, v6, 16);

        grafo.agregarArista(v5, v7, 12);

        grafo.agregarArista(v6, v0, 13);
        grafo.agregarArista(v6, v9, 25);

        grafo.agregarArista(v7, v9, 17);
        grafo.agregarArista(v7, v3, 19);

        grafo.agregarArista(v8, v5, 14);
        grafo.agregarArista(v8, v4, 22);
        grafo.agregarArista(v8, v7, 16);

        Vertice inicio = v0;
        Vertice fin = v9;

        List<Position> camino = grafo.dijkstra(inicio, fin);

        return camino;

    }
    private void setMaps() {
        maps = new ArrayList<>();

        // Mapa 0 se conecta al Mapa 1
        int[] connections0 = {-1, 1, -1, -1};
        maps.add(new Map(0, new PositionBarrier().map1Barrier(), connections0));
        // Mapa 1 se conecta al Mapa 0 y al Mapa 2
        int[] connections1 = {-1,2,-1,-1};
        maps.add(new Map(1, new PositionBarrier().map2Barrier(), connections1));
        // Mapa 2 se conecta solo al Mapa 1
        int[] connections2 = {-1, 3, -1, -1};
        maps.add(new Map(2, new PositionBarrier().map3Barrier(), connections2));
        int[] connections3 = {-1, 4, -1, -1};
        maps.add(new Map(3, new PositionBarrier().map4Barrier(), connections3));
        int[] connections4 = {-1, -1, -1, -1};
        maps.add(new Map(4, new PositionBarrier().map5Barrier(), connections4));

    }

    private void AvatarCollideWithObstacles() {
        Position aPos = avatar.getPosition();

        for (Bricks barrier : maps.get(currentMap).getBlocks()) {
            Position oPos = barrier.position;
            if (aPos.getX() < oPos.getX() +barrier.getWidth() &&
                    aPos.getX() + avatar.getWidth() > oPos.getX() &&
                    aPos.getY() < oPos.getY() + barrier.getHeight() &&
                    aPos.getY() + avatar.getHeight() > oPos.getY()) {
                double difSup = Math.abs(aPos.getY() + avatar.getHeight() - oPos.getY());
                double difInf = Math.abs(aPos.getY() - (oPos.getY() + barrier.getHeight()));
                double difRight = Math.abs(aPos.getX() + avatar.getWidth() - oPos.getX());
                double difLeft = Math.abs(aPos.getX() - (oPos.getX() + barrier.getWidth()));

                if (difSup < 9) {
                    aPos.setY(aPos.getY() - 3);
                }
                if (difInf < 9) {
                    aPos.setY(aPos.getY() + 3);
                }
                if (difLeft < 9) {
                    aPos.setX(aPos.getX() - 3);
                }
                if (difRight < 9) {
                    aPos.setX(aPos.getX() + 3);
                }
            }
        }
    }

    private void AvatarObstacleCollition(Bricks barrier) {
        Position aPos = avatar.getPosition();
        Position oPos = barrier.position;
        double limX = 0;
        double limY = aPos.getY() - oPos.getY();
        if((limX > (-avatar.getWidth()) && limX < barrier.getWidth()) && limY> (-avatar.getHeight()) && limY < (barrier.getHeight())){
            double difSup = Math.abs(limY+avatar.getHeight());
            double difInf = Math.abs(limY-barrier.getHeight());
            double difRight = Math.abs(limX-barrier.getWidth());
            double difLeft = Math.abs(limX+avatar.getWidth());

            if(difSup < 9){
                aPos.setY(aPos.getY()-3);
            }
            if(difInf < 9){
                aPos.setY(aPos.getY()+3);
            }
            if(difLeft < 9){
                aPos.setX(aPos.getX()-3);
            }
            if(difRight < 9){
                aPos.setX(aPos.getX()+3);
            }

        }
    }
}
