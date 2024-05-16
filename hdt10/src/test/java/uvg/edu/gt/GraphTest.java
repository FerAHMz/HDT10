package uvg.edu.gt;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GraphTest {
    private Graph graph;

    @BeforeEach
    void setUp() {
        graph = new Graph(5); // Asumimos que hay 5 vértices para las pruebas
        // Configuración inicial de aristas conocidas para pruebas
        graph.addEdge(0, 1, 10);
        graph.addEdge(1, 2, 20);
        graph.addEdge(2, 3, 30);
        graph.addEdge(3, 4, 40);
        graph.addEdge(4, 0, 50);
    }

    @Test
    void testAddEdge() {
        assertEquals(Integer.MAX_VALUE, graph.getWeight(0, 2), "Initial weight should be INF");
        graph.addEdge(0, 2, 15);
        assertEquals(15, graph.getWeight(0, 2), "Weight should be updated to 15");
    }

    @Test
    void testFloydWarshall() {
        graph.floydWarshall();
        assertEquals(10, graph.getWeight(0, 1), "Shortest path from 0 to 1 should be 10");
        assertEquals(30, graph.getWeight(0, 2), "Shortest path from 0 to 2 should be 30");
        assertEquals(60, graph.getWeight(0, 3), "Shortest path from 0 to 3 should be 60");
    }

    @Test
    void testFindGraphCenter() {
        graph.floydWarshall();
        int center = graph.findGraphCenter();
        assertEquals(0, center, "Vertex 0 should be the center of the graph");
    }
}
