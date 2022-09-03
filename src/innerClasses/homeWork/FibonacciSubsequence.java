package innerClasses.homeWork;

public class FibonacciSubsequence {
    public static int[] fibonacciSubsequence = new int[9];

    static {
        countSubsequence(0);
    }

    private static void countSubsequence(int index) {
        if (index == 0) {
            fibonacciSubsequence[index] = 0;
            index = 1;
            fibonacciSubsequence[index] = 1;
        } else if (index == 9) {
            return;
        } else {
            fibonacciSubsequence[index] = fibonacciSubsequence[index - 2] + fibonacciSubsequence[index - 1];
        }
        countSubsequence(++index);
    }

    public static int getValueByIndex(int index) {
        return fibonacciSubsequence[index];
    }
}
