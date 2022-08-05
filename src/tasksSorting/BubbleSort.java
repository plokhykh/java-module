package tasksSorting;

import java.util.Arrays;

public class BubbleSort {
    static int[] array = {10, 4, 5, 2, 8, 9, 1, 3, 7, 6};
    public static void main(String[] args) {
        System.out.println(Arrays.toString(bubbleSort(array)));
    }

    public static int[] bubbleSort (int[] array){
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i-1]){
                int temporary = array[i];
                array[i] = array[i-1];
                array[i-1] = temporary;
                bubbleSort(array);
            }
        }
        return array;
    }
}