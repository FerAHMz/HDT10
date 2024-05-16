package uvg.edu.gt;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Asumimos que sabemos el número total de vértices de antemano
        int numberOfVertices = 5; 
        Graph graph = new Graph(numberOfVertices);

        // Añadir algunas aristas para prueba
        graph.addEdge(0, 1, 10);
        graph.addEdge(1, 2, 20);
        graph.addEdge(2, 3, 30);
        graph.addEdge(3, 4, 40);
        graph.addEdge(4, 0, 50);

        // Iniciar la interfaz de línea de comandos con el grafo
        GraphCLI cli = new GraphCLI(graph);
        cli.startCLI();
    }
}



