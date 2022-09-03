package sorting;

import java.util.Arrays;

public class InsertionSort {
    static int[] array = {10, 4, 5, 2, 8, 9, 1, 3, 7, 6};

    public static void main(String[] args) {
        System.out.println(Arrays.toString(insertionSort(array)));
    }

    public static int[] insertionSort(int[] array) {

        for (int i = 1; i < array.length; i++) {
            int value = array[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (value < array[j]) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = value;
        }
        return array;
    }
}