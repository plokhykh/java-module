package tasks;

public class Case {
    public static void main(String[] args) {
        //20  Даны два целых числа: D (день) и M (месяц), определяющие правильную дату. Вывести знак Зодиака, соответствующий этой дате: «Водолей» (20.1–18.2), «Рыбы» (19.2–20.3), «Овен» (21.3–19.4), «Телец» (20.4–20.5), «Близнецы» (21.5–21.6), «Рак» (22.6–22.7), «Лев» (23.7–22.8), «Дева» (23.8–22.9), «Весы» (23.9–22.10), «Скорпион» (23.10–22.11), «Стрелец» (23.11–21.12), «Козерог» (22.12–19.1).
        System.out.println(defineZodiac(21, 3));
//        int day = 1;
//        int month = 2;
//
//        String zodiac = switch (month){
//            case 1 -> day >= 20 ? "Водолей" : "Козерог";
//            case 2 -> day >= 19? "Рыбы" : "Водолей";
//            case 3 -> day >= 21? "Овен" : "Рыбы";
//            case 4 -> day >= 20? "Телец" : "Овен";
//            case 5 -> day >= 21? "Близнецы" : "Телец";
//            case 6 -> day >= 22? "Рак" : "Близнецы";
//            case 7 -> day >= 23? "Лев" : "Рак";
//            case 8 -> day >= 23? "Дева" : "Лев";
//            case 9 -> day >= 23? "Весы" : "Дева";
//            case 10 -> day >= 23? "Скорпион" : "Весы";
//            case 11 -> day >= 23? "Стрелец" : "Скорпион";
//            case 12 -> day >= 22? "Козерог" : "Стрелец";
//            default -> "Undefined";
//        };
//        System.out.println(zodiac);
    }

    public static String defineZodiac(int day, int month) {

        switch (month) {
            case 1:
                return day >= 20 ? "Водолей" : "Козерог";
            case 2:
                return day >= 19? "Рыбы" : "Водолей";
            case 3:
                return day >= 21? "Овен" : "Рыбы";
            case 4:
                return day >= 20? "Телец" : "Овен";
            case 5:
                return day >= 21? "Близнецы" : "Телец";
            case 6:
                return day >= 22? "Рак" : "Близнецы";
            case 7:
                return day >= 23? "Лев" : "Рак";
            case 8:
                return day >= 23? "Дева" : "Лев";
            case 9:
                return day >= 23? "Весы" : "Дева";
            case 10:
                return day >= 23? "Скорпион" : "Весы";
            case 11:
                return day >= 23? "Стрелец" : "Скорпион";
            case 12:
                return day >= 22? "Козерог" : "Стрелец";
            default:
                throw new IllegalArgumentException();

        }
    }
}
