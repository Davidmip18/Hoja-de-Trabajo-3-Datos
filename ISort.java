/**
 * Interfaz que deben implementar todos los algoritmos de ordenamiento.
 * Usa Genéricos que extiendan de Comparable para cumplir con el requisito.
 */
public interface ISort<T extends Comparable<T>> {
    // Método principal que ordena el arreglo
    void sort(T[] arr);
    
    // Devuelve el nombre del algoritmo (útil para imprimir resultados)
    String getName();
}
