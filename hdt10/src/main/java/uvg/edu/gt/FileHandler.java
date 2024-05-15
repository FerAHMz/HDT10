package uvg.edu.gt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileHandler {

    // Método para leer el grafo desde un archivo ubicado en el sistema de archivos
    public static List<String[]> readGraphFromFile(String filePath) {
        List<String[]> edges = new ArrayList<>();
        File file = new File(filePath);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] tokens = line.split(" ");
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



