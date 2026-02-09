public class GnomeSort<T extends Comparable<T>> implements ISort<T> {
    @Override
    public void sort(T[] arr) {
        int index = 0;
        while (index < arr.length) {
            if (index == 0) {
                index++;
            }
            // Si el actual es mayor o igual al anterior, avanzamos
            if (arr[index].compareTo(arr[index - 1]) >= 0) {
                index++;
            } else {
                // Si no, intercambiamos y retrocedemos (swap manual)
                T temp = arr[index];
                arr[index] = arr[index - 1];
                arr[index - 1] = temp;
                index--;
            }
        }
    }
    
    @Override
    public String getName() { return "Gnome Sort"; }
}
