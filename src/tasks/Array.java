package tasks;

public class Array {
    static int[] sortedArray = {1, 1, 2, 3, 4, 4, 5};
    static int[] array = {2, 5, 7, 3, 2, 4, 2, 1, 4, 3};

    public static void main(String[] args) {
        //43 Дан масив, всі елементи впорядковані по зростанню чи зменшенню. Знайти кількість різних елементів в даному масиві
        System.out.println(countUniqueValues(sortedArray));
        //47 Дан масив, знайти кількість різних значень
        System.out.println(countUniqueNumbers(array));
    }

    //ну або через HashSet
    public static int countUniqueValues(int[] array) {
        int count = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] != array[i - 1]) {
                count += 1;
            }
        }
        return count;
    }

    //    ??  HashSet stream.distinct
    public static int countUniqueNumbers(int[] array) {
//        int count = 0;
//        for (int i = 0; i < array.length - 1; i++) {
//            for (int j = 0; j < array.length; j++) {
//                if (array[i] != array[j]) {
//                    count += 1;
//                }
//
//            }
//        }
        int num = 1;
        for (int i = 1; i < array.length; ++i, ++num) {
            for (int j = i - 1; j >= 0 ;--j){
                if (array[i] == array[j]) {
                    --num;
                    break;
                }
            }
        }
        return num;
    }


}
