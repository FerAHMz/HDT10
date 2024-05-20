package uvg.edu.gt;

/**
 * Interfaz que define los métodos básicos para un grafo.
 * Proporciona métodos para añadir y eliminar arcos, ejecutar el algoritmo de Floyd-Warshall,
 * y encontrar el centro del grafo basado en la excentricidad de los vértices.
 */
public interface GraphInterface {
    
    /**
     * Añade un arco al grafo con un peso específico.
     *
     * @param source el vértice de origen.
     * @param dest el vértice de destino.
     * @param weight el peso del arco.
     */
    void addEdge(int source, int dest, int weight);

    /**
     * Elimina un arco del grafo.
     *
     * @param source el vértice de origen.
     * @param dest el vértice de destino.
     */
    void removeEdge(int source, int dest);

    /**
     * Ejecuta el algoritmo de Floyd-Warshall y actualiza la matriz de distancias.
     */
    void floydWarshall();

    /**
     * Encuentra el centro del grafo basado en la excentricidad de los vértices.
     *
     * @return el vértice que es el centro del grafo.
     */
    int findGraphCenter();
}

