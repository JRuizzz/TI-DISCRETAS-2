
import com.example.misionprofesoricesi.util.Edge;
import com.example.misionprofesoricesi.util.Graph;
import com.example.misionprofesoricesi.util.Vertex;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class GraphTest {

    @Test
    public void testAddVertex() {
        Graph graph = new Graph();
        Vertex v1 = graph.addVertex();
        Vertex v2 = graph.addVertex();
        assertNotNull(v1);
        assertNotNull(v2);
        assertEquals(2, graph.getVertices().size());
    }

    @Test
    public void testAddEdge() {
        Graph graph = new Graph();
        Vertex v1 = graph.addVertex();
        Vertex v2 = graph.addVertex();
        Edge e = graph.addEdge(v1, v2);
        assertNotNull(e);
        assertEquals(1, graph.getEdges().size());
    }

    @Test
    public void testRemoveVertex() {
        Graph graph = new Graph();
        Vertex v1 = graph.addVertex();
        Vertex v2 = graph.addVertex();
        Edge e = graph.addEdge(v1, v2);
        graph.removeVertex(v1);
        assertEquals(1, graph.getVertices().size());
        assertEquals(0, graph.getEdges().size());
    }

    @Test
    public void testRemoveEdge() {
        Graph graph = new Graph();
        Vertex v1 = graph.addVertex();
        Vertex v2 = graph.addVertex();
        Edge e = graph.addEdge(v1, v2);
        graph.removeEdge(e);
        assertEquals(0, graph.getEdges().size());
    }

    @Test
    public void testHasConnection() {
        Graph graph = new Graph();
        Vertex v1 = graph.addVertex();
        Vertex v2 = graph.addVertex();
        Vertex v3 = graph.addVertex();
        graph.addEdge(v1, v2);
        assertTrue(graph.hasConnection(v1, v2));
        assertFalse(graph.hasConnection(v1, v3));
    }
}
