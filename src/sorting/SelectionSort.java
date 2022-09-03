package sorting;

import java.util.Arrays;

public class SelectionSort {
    static int[] array = {10, 4, 5, 2, 8, 9, 1, 3, 7, 6};

    public static void main(String[] args) {
        System.out.println(Arrays.toString(selectionSort(array)));
    }

    public static int[] selectionSort(int[] array) {
        int max = 0;
        int ind = 0;
        for (int i = 0; i < array.length; i++) {
            int remainingLength = array.length - 1 - i;
            for (int j = remainingLength; j >= 0; j--) {
                if (array[j] > max) {
                    max = array[j];
                    ind = j;
                }
            }
            int temporary = array[remainingLength];
            array[remainingLength] = max;
            max = 0;
            array[ind] = temporary;
        }

        return array;
    }
}