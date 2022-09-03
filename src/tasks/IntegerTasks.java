package tasks;

public class IntegerTasks {
    public static void main(String[] args) {
        //7 Дано двузначное число. Найти сумму и произведение его цифр.
        int value = 25;
        int n = value % 10;
        int m = value/10;

        int sum = n + m;
        int multiplication = n * m;
        System.out.println("сума - "+sum);
        System.out.println("множення - "+multiplication);

        //29 Даны целые положительные числа A, B, C. На прямоугольнике размера A × B размещено максимально возможное количество квадратов со стороной C (без наложений). Найти количество квадратов, размещенных на прямоугольнике, а также площадь незанятой части прямоугольника.
        countSquareInRectangle(3, 9, 2);
        //30 Дан номер некоторого года (целое положительное число). Определить соответствующий ему номер столетия, учитывая, что, к примеру, на- чалом 20 столетия был 1901 год.
        System.out.println(getCentury(1893));
    }

    public static void countSquareInRectangle (int A, int B, int C){
        //посмотрела решение, не отличается от моего
        double rectangleArea = A*B;
        double squareArea = Math.pow(C, 2);

        if(squareArea>rectangleArea) return;

        double occupiedArea = rectangleArea/squareArea;
        double free = occupiedArea%1;
        double freeArea = free*squareArea;
        int availableSquare = (int) occupiedArea;

        System.out.print("в прмякутнику буде разміщено "+availableSquare+" квадратів і "+freeArea+" кв.м. вільної площі");
        System.out.println();
    }

    public static int getCentury (int year){
        int res = ((year-1)/100)+1;
        return res;
    }
}
