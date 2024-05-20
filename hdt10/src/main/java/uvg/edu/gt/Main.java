package uvg.edu.gt;

import java.util.*;

public class Main {
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


