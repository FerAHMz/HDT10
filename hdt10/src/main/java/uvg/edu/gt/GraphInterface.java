package uvg.edu.gt;

public interface GraphInterface {
    // Método para añadir un arco al grafo con un peso específico
    void addEdge(int source, int dest, int weight);

    // Método para eliminar un arco del grafo
    void removeEdge(int source, int dest);

    // Método para ejecutar el algoritmo de Floyd-Warshall y actualizar la matriz de distancias
    void floydWarshall();

    // Método para encontrar el centro del grafo basado en la excentricidad de los vértices
    int findGraphCenter();
}

