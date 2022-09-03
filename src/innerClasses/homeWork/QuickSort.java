package innerClasses.homeWork;

public class QuickSort {

    public static void sort(int[] array, int left, int right) {
        if (array.length == 0) return;
        if (left >= right) return;

        int i = left;
        int j = right;
        int middle = left + (right - left) / 2;
        int p = array[middle];

        while (i <= j) {
            while (array[i] < p) {
                i++;
            }

            while (array[j] > p) {
                j--;
            }

            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        if (left < j) sort(array, left, j);
        if (right > i) sort(array, i, right);

    }
}
