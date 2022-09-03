package innerClasses.homeWork;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
     static int[] array = {56, 89,21, 4, 55, 79, 9, 34, 25};
    public static void main(String[] args) {
        System.out.println(Factorial.getFactorial(6));

        QuickSort.sort(array,0, array.length-1);
        System.out.println(Arrays.toString(array));

        System.out.println(FibonacciSubsequence.getValueByIndex(6));



    }
}
