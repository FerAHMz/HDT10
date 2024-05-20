package uvg.edu.gt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase para manejar la lectura de archivos que contienen información sobre grafos.
 * Proporciona métodos para leer un grafo desde un archivo en el sistema de archivos.
 */
public class FileHandler {

    /**
     * Lee un grafo desde un archivo ubicado en el sistema de archivos.
     * Cada línea del archivo debe contener tres elementos separados por espacios:
     * el vértice de origen, el vértice de destino y el peso del arco.
     *
     * @param filePath la ruta del archivo que contiene la información del grafo.
     * @return una lista de arreglos de cadenas, donde cada arreglo representa un arco con su peso.
     */
    public static List<String[]> readGraphFromFile(String filePath) {
        List<String[]> edges = new ArrayList<>();
        File file = new File(filePath);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();  // Elimina espacios en blanco al inicio y al final
                String[] tokens = line.split("\\s+");  // Divide en uno o más espacios
                if (tokens.length == 3) {
                    edges.add(tokens);
                } else {
                    System.out.println("Skipping invalid line: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
            e.printStackTrace();
        }
        return edges;
    }
}



