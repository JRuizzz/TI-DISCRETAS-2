import com.example.animationsgame.model.Arista;
import com.example.animationsgame.model.Position;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.example.animationsgame.model.Vertice;
import com.example.animationsgame.model.Grafo;

import java.util.List;


public class GrafoTest {

    @Test
    public void testAgregarVertice() {
        Grafo grafo = new Grafo();

        Vertice v0 = grafo.agregarVertice(0, 100, 100);

        assertNotNull(v0);
        assertEquals(1, grafo.getVertices().size());
        assertTrue(grafo.getVertices().contains(v0));
    }

    @Test
    public void testAgregarVerticeConCoordenadasNegativas() {
        Grafo grafo = new Grafo();

        Vertice v1 = grafo.agregarVertice(1, -50, -50);

        assertNotNull(v1);
        assertEquals(1, grafo.getVertices().size());
        assertTrue(grafo.getVertices().contains(v1));
    }

        @Test
        public void testAgregarVerticeRepetido() {
            Grafo grafo = new Grafo();

            Vertice v0 = grafo.agregarVertice(0, 100, 100);

            assertNotNull(v0);
            assertEquals(1, grafo.getVertices().size());

            Vertice v0Repetido = grafo.agregarVertice(0, 200, 200);

            assertNotNull(v0Repetido);
            assertEquals(2, grafo.getVertices().size());
        }

    @Test
    public void testAgregarArista() {
        Grafo grafo = new Grafo();

        Vertice v0 = grafo.agregarVertice(0, 100, 100);
        Vertice v1 = grafo.agregarVertice(1, 200, 200);

        Arista arista = grafo.agregarArista(v0, v1, 2);

        assertNotNull(arista);
        assertEquals(1, grafo.getEdges().size());
        assertTrue(grafo.getEdges().contains(arista));
    }

    @Test
    public void testAgregarAristaConPesoNegativoAlternativo() {
        Grafo grafo = new Grafo();

        Vertice v0 = grafo.agregarVertice(0, 100, 100);
        Vertice v1 = grafo.agregarVertice(1, 200, 200);

        // Intentar agregar una arista con peso negativo
        Arista arista = grafo.agregarArista(v0, v1, -2);

        // Verificar que la arista no se agregó correctamente
        assertNull(arista);

        // Verificar que la lista de aristas sigue vacía
        assertEquals(0, grafo.getEdges().size());
    }

    @Test
    public void testAgregarAristaConVerticeNulo() {
        Grafo grafo = new Grafo();

        Vertice v0 = grafo.agregarVertice(0, 100, 100);
        Vertice v1 = null; // Vértice nulo

        // Intentar agregar una arista con un vértice nulo
        Arista arista = grafo.agregarArista(v0, v1, 3);

        // Verificar que la arista no se agregó correctamente
        assertNull(arista);

        // Verificar que la lista de aristas sigue vacía
        assertEquals(0, grafo.getEdges().size());

        // Verificar que la lista de vértices sigue teniendo el vértice original
        assertEquals(1, grafo.getVertices().size());
        assertTrue(grafo.getVertices().contains(v0));
    }

    @Test
    public void testDijkstra() {
        Grafo grafo = new Grafo();

        Vertice v0 = grafo.agregarVertice(0, 1, 100);
        Vertice v1 = grafo.agregarVertice(1, 420, 200);
        Vertice v2 = grafo.agregarVertice(2, 333, 300);

        grafo.agregarArista(v0, v1, 2);
        grafo.agregarArista(v1, v2, 3);

        List<Position> camino = grafo.dijkstra(v0, v2);

        assertNotNull(camino);
        assertEquals(3, camino.size());

        // Verificar que el camino es correcto
        assertEquals(1, camino.get(0).getX());
        assertEquals(420, camino.get(1).getX());
        assertEquals(333, camino.get(2).getX());
    }

    @Test
    public void testDijkstraGrafoPequeno() {
        Grafo grafo = new Grafo();

        Vertice v0 = grafo.agregarVertice(0, 1, 1);
        Vertice v1 = grafo.agregarVertice(1, 2, 2);
        Vertice v2 = grafo.agregarVertice(2, 3, 3);

        grafo.agregarArista(v0, v1, 1);
        grafo.agregarArista(v1, v2, 2);

        List<Position> camino = grafo.dijkstra(v0, v2);

        assertNotNull(camino);
        assertEquals(3, camino.size());

        // Verificar que el camino es correcto
        assertEquals(1, camino.get(0).getX());
        assertEquals(2, camino.get(1).getX());
        assertEquals(3, camino.get(2).getX());
    }

    @Test
    public void testDijkstraGrafoGrande() {
        Grafo grafo = new Grafo();

        Vertice v0 = grafo.agregarVertice(0, 1, 1);
        Vertice v1 = grafo.agregarVertice(1, 2, 2);
        Vertice v2 = grafo.agregarVertice(2, 3, 3);
        Vertice v3 = grafo.agregarVertice(3, 4, 4);
        Vertice v4 = grafo.agregarVertice(4, 5, 5);

        grafo.agregarArista(v0, v1, 1);
        grafo.agregarArista(v1, v2, 2);
        grafo.agregarArista(v2, v3, 3);
        grafo.agregarArista(v3, v4, 4);

        List<Position> camino = grafo.dijkstra(v0, v4);

        assertNotNull(camino);
        assertEquals(5, camino.size());

        // Verificar que el camino es correcto
        assertEquals(1, camino.get(0).getX());
        assertEquals(2, camino.get(1).getX());
        assertEquals(3, camino.get(2).getX());
        assertEquals(4, camino.get(3).getX());
        assertEquals(5, camino.get(4).getX());
    }

}
