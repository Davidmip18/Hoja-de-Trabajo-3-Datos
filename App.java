import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        ISort[] algoritmos = {
            new GnomeSort<Integer>(),
            new MergeSort<Integer>(),
            new QuickSort<Integer>(),
            new RadixSort(),
            new ShellSort<Integer>()
        };
        
        int[] tamaños = {10, 100, 500, 1000, 2000, 3000};
        String archivo = "datos.txt";
        
        System.out.println("Algoritmo, Cantidad, Tipo, Tiempo(ns)");
        
        try {
            for (int n : tamaños) {
                // 1. Generar archivo nuevo con N datos
                DataManager.generateData(archivo, n);
                Integer[] baseData = DataManager.readData(archivo);
                
                for (ISort algo : algoritmos) {
                    // --- PRUEBA DESORDENADA ---
                    Integer[] dataCopy = Arrays.copyOf(baseData, baseData.length);
                    
                    long startTime = System.nanoTime(); // Inicio Cronómetro
                    algo.sort(dataCopy);
                    long endTime = System.nanoTime();   // Fin Cronómetro
                    
                    System.out.printf("%s, %d, Desordenado, %d\n", algo.getName(), n, (endTime - startTime));
                    
                    // --- PRUEBA YA ORDENADA ---
                    // dataCopy ya está ordenado del paso anterior. Lo usamos de input.
                    startTime = System.nanoTime();
                    algo.sort(dataCopy);
                    endTime = System.nanoTime();
                    
                    System.out.printf("%s, %d, Ordenado, %d\n", algo.getName(), n, (endTime - startTime));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
