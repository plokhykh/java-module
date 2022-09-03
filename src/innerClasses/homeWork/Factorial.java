package innerClasses.homeWork;

 public class Factorial {
    public static int getFactorial(int n) {
        int sum = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
        }
        return sum;
    }
}
