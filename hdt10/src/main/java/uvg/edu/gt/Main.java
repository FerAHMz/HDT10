package uvg.edu.gt;

import java.util.*;

/**
 * Clase principal que inicializa el grafo desde un archivo, asigna índices a las ciudades,
 * añade aristas al grafo y lanza la interfaz de línea de comandos (CLI) para interactuar con el grafo.
 */
public class Main {
    /**
     * Método principal que ejecuta la aplicación.
     *
     * @param args los argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        String filePath = "G:\\My Drive\\Tercer Semestre\\Algoritmos y Estructura de Datos\\HDT10\\hdt10\\guategrafo.txt";
        List<String[]> edges = FileHandler.readGraphFromFile(filePath);
        Map<String, Integer> cityIndexMap = new HashMap<>();
        int vertexIndex = 0;
        
        // Asignar índices a las ciudades
        for (String[] edge : edges) {
            if (!cityIndexMap.containsKey(edge[0])) {
                cityIndexMap.put(edge[0], vertexIndex++);
            }
            if (!cityIndexMap.containsKey(edge[1])) {
                cityIndexMap.put(edge[1], vertexIndex++);
            }
        }

        int numberOfVertices = cityIndexMap.size();
        Graph graph = new Graph(numberOfVertices);

        // Añadir aristas usando índices mapeados
        for (String[] edge : edges) {
            int source = cityIndexMap.get(edge[0]);
            int destination = cityIndexMap.get(edge[1]);
            int weight = Integer.parseInt(edge[2]);
            graph.addEdge(source, destination, weight);
        }

        GraphCLI cli = new GraphCLI(graph);
        cli.startCLI();
    }
}



