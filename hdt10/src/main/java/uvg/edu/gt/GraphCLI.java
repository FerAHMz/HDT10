package uvg.edu.gt;

import java.util.Scanner;

public class GraphCLI {
    private Graph graph;
    private Scanner scanner;

    public GraphCLI(Graph graph) {
        this.graph = graph;
        this.scanner = new Scanner(System.in);
    }

    public void startCLI() {
        boolean running = true;
        while (running) {
            displayMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addEdge();
                    break;
                case 2:
                    removeEdge();
                    break;
                case 3:
                    showFloydWarshall();
                    break;
                case 4:
                    showGraphCenter();
                    break;
                case 5:
                    running = false;
                    scanner.close();
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
                    break;
            }
        }
    }

    private void displayMenu() {
        System.out.println("\n--- Graph Operations Menu ---");
        System.out.println("1. Add Edge");
        System.out.println("2. Remove Edge");
        System.out.println("3. Show Shortest Paths (Floyd-Warshall)");
        System.out.println("4. Show Graph Center");
        System.out.println("5. Exit");
        System.out.print("Enter choice: ");
    }

    private void addEdge() {
        System.out.print("Enter source vertex: ");
        int source = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter destination vertex: ");
        int dest = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter weight: ");
        int weight = Integer.parseInt(scanner.nextLine());
        graph.addEdge(source, dest, weight);
        System.out.println("Edge added successfully.");
    }

    private void removeEdge() {
        System.out.print("Enter source vertex: ");
        int source = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter destination vertex: ");
        int dest = Integer.parseInt(scanner.nextLine());
        graph.removeEdge(source, dest);
        System.out.println("Edge removed successfully.");
    }

    private void showFloydWarshall() {
        graph.floydWarshall();
        System.out.println("Distance matrix updated using Floyd-Warshall algorithm:");
        int numberOfVertices = graph.getNumberOfVertices();
        for (int i = 0; i < numberOfVertices; i++) {
            for (int j = 0; j < numberOfVertices; j++) {
                int weight = graph.getWeight(i, j);
                if (weight == Integer.MAX_VALUE) {
                    System.out.print("INF ");
                } else {
                    System.out.print(weight + " ");
                }
            }
            System.out.println();
        }
    }

    private void showGraphCenter() {
        int center = graph.findGraphCenter();
        System.out.println("The center of the graph is vertex: " + center);
    }
}

