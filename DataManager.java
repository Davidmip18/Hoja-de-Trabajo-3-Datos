import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class DataManager {

    /**
     * Crea un archivo .csv con 'count' números aleatorios.
     * Si el nombre no termina en .csv, lo agrega automáticamente.
     */
    public static void generateData(String filename, int count) throws IOException {
        // Validación: Forzar extensión .csv
        if (!filename.endsWith(".csv")) {
            filename += ".csv"; 
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        Random rand = new Random();

        // Escribimos los números en una sola columna (formato CSV simple)
        for (int i = 0; i < count; i++) {
            // Escribe un número entre 0 y 10000 seguido de un salto de línea
            writer.write(rand.nextInt(10000) + "\n");
        }
        
        writer.close();
        System.out.println("Archivo generado exitosamente: " + filename);
    }

    /**
     * Lee un archivo .csv y devuelve los números en un arreglo.
     * Lanza un error si el archivo no es .csv
     */
    public static Integer[] readData(String filename) throws IOException {
        // Validación estricta: Solo aceptar .csv
        if (!filename.endsWith(".csv")) {
            throw new IllegalArgumentException("Error de Formato: El archivo debe tener extensión .csv");
        }

        ArrayList<Integer> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;

        while ((line = reader.readLine()) != null) {
            // Aseguramos no leer líneas vacías
            if (!line.trim().isEmpty()) {
                try {
                    list.add(Integer.parseInt(line.trim()));
                } catch (NumberFormatException e) {
                    System.err.println("Advertencia: Se ignoró una línea que no era un número.");
                }
            }
        }
        reader.close();
        
        // Convierte la lista dinámica a un arreglo estático Integer[] compatible con tus Sorts
        return list.toArray(new Integer[0]);
    }
}
