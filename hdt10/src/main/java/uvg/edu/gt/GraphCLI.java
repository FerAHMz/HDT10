package uvg.edu.gt;

import java.util.*;

/**
 * Clase que proporciona una interfaz de línea de comandos (CLI) para interactuar con un grafo.
 * Permite realizar operaciones como consultar la ruta más corta, mostrar el centro del grafo,
 * y modificar el grafo.
 */
public class GraphCLI {
    private Graph graph;
    private Scanner scanner;
    private Map<String, Integer> cityIndexMap;
    private Map<Integer, String> indexToCityMap;

    /**
     * Constructor de la clase GraphCLI.
     * Inicializa el grafo, el escáner y los mapas de ciudades.
     *
     * @param graph el objeto Graph que se utilizará para las operaciones.
     */
    public GraphCLI(Graph graph) {
        this.graph = graph;
        this.scanner = new Scanner(System.in);
        this.cityIndexMap = new HashMap<>();
        this.indexToCityMap = new HashMap<>();
        initializeCityIndexMap();
    }

    /**
     * Inicializa el mapa de índices de ciudades con valores predefinidos.
     * También invierte el mapa para obtener el nombre de la ciudad a partir de su índice.
     */
    private void initializeCityIndexMap() {
        cityIndexMap.put("Mixco", 0);
        cityIndexMap.put("Antigua", 1);
        cityIndexMap.put("Escuintla", 2);
        cityIndexMap.put("SantaLucia", 3);
        cityIndexMap.put("Guatemala", 4);
        // Manual inversion of the map
        for (Map.Entry<String, Integer> entry : cityIndexMap.entrySet()) {
            indexToCityMap.put(entry.getValue(), entry.getKey());
        }
    }

    /**
     * Inicia la interfaz de línea de comandos y procesa las entradas del usuario.
     */
    public void startCLI() {
        boolean running = true;
        while (running) {
            displayMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    queryShortestPath();
                    break;
                case 2:
                    showGraphCenter();
                    break;
                case 3:
                    modifyGraph();
                    break;
                case 4:
                    running = false;
                    scanner.close();
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
                    break;
            }
        }
    }

    /**
     * Muestra el menú de operaciones disponibles en la CLI.
     */
    private void displayMenu() {
        System.out.println("\n--- Graph Operations Menu ---");
        System.out.println("1. Query shortest path between cities");
        System.out.println("2. Show the center of the graph");
        System.out.println("3. Modify the graph");
        System.out.println("4. Exit");
        System.out.print("Enter choice: ");
    }

    /**
     * Solicita al usuario las ciudades de origen y destino y muestra la ruta más corta entre ellas.
     * Utiliza el algoritmo de Floyd-Warshall para calcular las distancias.
     */
    private void queryShortestPath() {
        System.out.print("Enter source city: ");
        String sourceCity = scanner.nextLine();
        System.out.print("Enter destination city: ");
        String destinationCity = scanner.nextLine();

        if (!cityIndexMap.containsKey(sourceCity) || !cityIndexMap.containsKey(destinationCity)) {
            System.out.println("One or both cities are invalid.");
            return;
        }

        int source = cityIndexMap.get(sourceCity);
        int destination = cityIndexMap.get(destinationCity);
        graph.floydWarshall();
        System.out.println("The shortest path from " + sourceCity + " to " + destinationCity + " is:");
        System.out.println("Distance: " + graph.getWeight(source, destination));
        // Implement and call a method to print the actual path if necessary
    }

    /**
     * Muestra el centro del grafo basado en la excentricidad de los vértices.
     */
    private void showGraphCenter() {
        int center = graph.findGraphCenter();
        System.out.println("The center of the graph is: " + indexToCityMap.get(center));
    }

    /**
     * Permite al usuario modificar el grafo añadiendo o eliminando arcos entre ciudades.
     */
    private void modifyGraph() {
        System.out.println("Choose an option:");
        System.out.println("1. Interrupt traffic between two cities");
        System.out.println("2. Establish a connection between two cities");
        int choice = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter city one: ");
        String city1 = scanner.nextLine();
        System.out.print("Enter city two: ");
        String city2 = scanner.nextLine();
        System.out.print("Enter the distance (KM): ");
        int distance = Integer.parseInt(scanner.nextLine());

        if (choice == 1) {
            graph.addEdge(cityIndexMap.get(city1), cityIndexMap.get(city2), Integer.MAX_VALUE);
        } else if (choice == 2) {
            graph.addEdge(cityIndexMap.get(city1), cityIndexMap.get(city2), distance);
        }

        graph.floydWarshall();  // Recalculate shortest paths
        System.out.println("Graph updated and paths recalculated.");
    }
}

