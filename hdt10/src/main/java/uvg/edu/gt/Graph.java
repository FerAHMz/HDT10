package uvg.edu.gt;

public class Graph {
    private int[][] adjacencyMatrix;
    private int numberOfVertices;

    // Constructor de la clase Graph
    public Graph(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;
        adjacencyMatrix = new int[numberOfVertices][numberOfVertices];

        // Inicializa la matriz con valores de "infinito" excepto en la diagonal que será 0
        for (int i = 0; i < numberOfVertices; i++) {
            for (int j = 0; j < numberOfVertices; j++) {
                if (i == j) {
                    adjacencyMatrix[i][j] = 0;
                } else {
                    adjacencyMatrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
    }

    // Método para añadir un arco al grafo
    public void addEdge(int source, int dest, int weight) {
        if (source < numberOfVertices && dest < numberOfVertices) {
            adjacencyMatrix[source][dest] = weight;
        }
    }

    // Método para eliminar un arco del grafo
    public void removeEdge(int source, int dest) {
        if (source < numberOfVertices && dest < numberOfVertices) {
            adjacencyMatrix[source][dest] = Integer.MAX_VALUE;
        }
    }

    // Implementación del algoritmo de Floyd-Warshall para calcular la distancia más corta entre todos los pares de vértices
    public void floydWarshall() {
        // Imprimir la matriz antes de empezar el algoritmo
        System.out.println("Matriz de Adyacencia antes de Floyd-Warshall:");
        printMatrix();

        // Ejecución del algoritmo de Floyd-Warshall
        for (int k = 0; k < numberOfVertices; k++) {
            for (int i = 0; i < numberOfVertices; i++) {
                for (int j = 0; j < numberOfVertices; j++) {
                    if (adjacencyMatrix[i][k] != Integer.MAX_VALUE && adjacencyMatrix[k][j] != Integer.MAX_VALUE) {
                        int newDistance = adjacencyMatrix[i][k] + adjacencyMatrix[k][j];
                        if (newDistance < adjacencyMatrix[i][j]) {
                            adjacencyMatrix[i][j] = newDistance;
                        }
                    }
                }
            }
            System.out.println("Matriz de Adyacencia después de iterar con k = " + k + ":");
            printMatrix();
        }
    }

    // Método para imprimir la matriz de adyacencia
    private void printMatrix() {
        for (int i = 0; i < numberOfVertices; i++) {
            for (int j = 0; j < numberOfVertices; j++) {
                if (adjacencyMatrix[i][j] == Integer.MAX_VALUE) {
                    System.out.print("INF ");
                } else {
                    System.out.print(adjacencyMatrix[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    // Método para encontrar el centro del grafo
    public int findGraphCenter() {
        floydWarshall();  // Asegura que la matriz de distancias está actualizada
        int[] eccentricity = new int[numberOfVertices];
        int minEccentricity = Integer.MAX_VALUE;
        int center = -1;  // Inicializar con un valor no válido
    
        for (int i = 0; i < numberOfVertices; i++) {
            int maxDistance = 0;
            for (int j = 0; j < numberOfVertices; j++) {
                if (adjacencyMatrix[i][j] > maxDistance) {
                    maxDistance = adjacencyMatrix[i][j];
                }
            }
            eccentricity[i] = maxDistance;
            System.out.println("Vertex " + i + " eccentricity: " + maxDistance);
    
            if (eccentricity[i] < minEccentricity) {
                minEccentricity = eccentricity[i];
                center = i;
            }
        }
    
        System.out.println("Graph center found: Vertex " + center);
        return center;
    }
    

    // Métodos de acceso para numberOfVertices y adjacencyMatrix
    public int getNumberOfVertices() {
        return numberOfVertices;
    }

    public int getWeight(int source, int destination) {
        if (source < numberOfVertices && destination < numberOfVertices) {
            return adjacencyMatrix[source][destination];
        }
        return Integer.MAX_VALUE; // Retornar un valor por defecto si los índices no son válidos
    }
}
