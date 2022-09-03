package tasks;

public class Boolean {
    public static void main(String[] args) {
        //34 Даны координаты поля шахматной доски x, y (целые числа, лежащие в диапазоне 1–8). Учитывая, что левое нижнее поле доски (1, 1) является черным, проверить истинность высказывания: «Данное поле является белым».
        System.out.println(isWhiteFieldChessBoard(2, 1));
        //40 Даны координаты двух различных полей шахматной доски x1, y1, x2, y2 (целые числа, лежащие в диапазоне 1–8). Проверить истинность высказывания: «Конь за один ход может перейти с одного поля на другое».
//        isHorseMove(1, 1, 3, 2);
    }

    public static boolean isWhiteFieldChessBoard(int x, int y) {
//        if ((x % 2 == 0) && (y % 2 == 0) || (x % 2 != 0) && (y % 2 != 0)) return false;
//        return true;
        return (x + y) % 2 != 0;
    }

    public static boolean isHorseMove(int x1, int y1, int x2, int y2) {
        if (Math.abs(x1 - x2) == 1 && Math.abs(y1 - y2) == 2 || Math.abs(x1 - x2) == 2 && Math.abs(y1 - y2) == 1) {
            return true;
        } else {
            return false;
        }
    }

}
