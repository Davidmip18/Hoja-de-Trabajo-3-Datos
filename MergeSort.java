import java.lang.reflect.Array;

public class MergeSort<T extends Comparable<T>> implements ISort<T> {
    @Override
    public void sort(T[] arr) {
        if (arr.length <= 1) return;
        
        // Es necesario crear arreglos auxiliares. 
        // Nota: Manejar genéricos con arrays en Java es delicado, 
        // aquí usamos un cast seguro asumiendo que el input es correcto.
        Class<?> clazz = arr.getClass().getComponentType();
        T[] aux = (T[]) Array.newInstance(clazz, arr.length);
        
        mergeSort(arr, aux, 0, arr.length - 1);
    }

    private void mergeSort(T[] arr, T[] aux, int low, int high) {
        if (low >= high) return;
        int mid = low + (high - low) / 2;
        mergeSort(arr, aux, low, mid);
        mergeSort(arr, aux, mid + 1, high);
        merge(arr, aux, low, mid, high);
    }

    private void merge(T[] arr, T[] aux, int low, int mid, int high) {
        // Copiar a auxiliar
        for (int k = low; k <= high; k++) aux[k] = arr[k];

        int i = low, j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i > mid)                   arr[k] = aux[j++];
            else if (j > high)             arr[k] = aux[i++];
            else if (aux[j].compareTo(aux[i]) < 0) arr[k] = aux[j++];
            else                           arr[k] = aux[i++];
        }
    }
    
    @Override
    public String getName() { return "Merge Sort"; }
}
