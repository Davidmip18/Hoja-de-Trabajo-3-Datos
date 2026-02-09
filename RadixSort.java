import java.util.Arrays;

public class RadixSort implements ISort<Integer> {
    @Override
    public void sort(Integer[] arr) {
        if (arr.length == 0) return;
        // Encontrar el máximo para saber número de dígitos
        int max = Arrays.stream(arr).mapToInt(Integer::intValue).max().orElse(0);
        
        // Hacer count sort para cada dígito (1s, 10s, 100s...)
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(arr, exp);
        }
    }

    private void countSort(Integer[] arr, int exp) {
        int n = arr.length;
        Integer[] output = new Integer[n];
        int[] count = new int[10];
        Arrays.fill(count, 0);

        for (int i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;

        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        for (int i = 0; i < n; i++)
            arr[i] = output[i];
    }
    
    @Override
    public String getName() { return "Radix Sort"; }
}
