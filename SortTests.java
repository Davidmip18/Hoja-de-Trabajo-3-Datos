import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;
import java.util.Arrays;

public class SortTests {
    
    private Integer[] getUnsorted() {
        return new Integer[]{5, 1, 4, 2, 8};
    }
    
    private Integer[] getSorted() {
        return new Integer[]{1, 2, 4, 5, 8};
    }

    @Test
    public void testShellSort() {
        ISort<Integer> sorter = new ShellSort<>();
        Integer[] data = getUnsorted();
        sorter.sort(data);
        assertArrayEquals(getSorted(), data);
    }
    
    @Test
    public void testQuickSort() {
        ISort<Integer> sorter = new QuickSort<>();
        Integer[] data = getUnsorted();
        sorter.sort(data);
        assertArrayEquals(getSorted(), data);
    }
    
    @Test
    public void testMergeSort() {
        ISort<Integer> sorter = new MergeSort<>();
        Integer[] data = getUnsorted();
        sorter.sort(data);
        assertArrayEquals(getSorted(), data);
    }    
        @Test
    public void testRadixSort() {
        ISort<Integer> sorter = new RadixSort();
        Integer[] data = getUnsorted();
        sorter.sort(data);
        assertArrayEquals(getSorted(), data);
    }
    
        @Test
    public void testGnomeSort() {
        ISort<Integer> sorter = new GnomeSort<>();
        Integer[] data = getUnsorted();
        sorter.sort(data);
        assertArrayEquals(getSorted(), data);
    }
    // Repetir para los otros 3 algoritmos...
}
