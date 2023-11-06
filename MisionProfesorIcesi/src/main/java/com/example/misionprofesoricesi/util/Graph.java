package com.example.misionprofesoricesi.util;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    List<Vertex> vertices;
    List<Edge> edges;

    public Graph() {
        vertices = new ArrayList<>();
        edges = new ArrayList<>();
    }

    public Vertex addVertex() {
        Vertex newVertex = new Vertex(vertices.size() + 1);
        vertices.add(newVertex);
        return newVertex;
    }

    public Edge addEdge(Vertex v1, Vertex v2) {
        Edge newEdge = new Edge(v1, v2);
        edges.add(newEdge);
        return newEdge;
    }

    public void removeVertex(Vertex v) {
        vertices.remove(v);
        edges.removeIf(e -> e.v1 == v || e.v2 == v);
    }

    public void removeEdge(Edge e) {
        edges.remove(e);
    }

    public List<Vertex> getVertices() {
        return vertices;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public boolean hasConnection(Vertex v1, Vertex v2) {
        boolean hasConnection = false;
        for (Edge e : edges) {
            if ((e.v1 == v1 && e.v2 == v2) || (e.v1 == v2 && e.v2 == v1)) {
                hasConnection = true;
                break;
            }
        }
        return hasConnection;
    }
}
