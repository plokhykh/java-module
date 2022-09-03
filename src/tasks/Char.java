package tasks;


import java.util.*;

public class Char {
    static char[] charArray = {'A', 'A', 'a', 'b', 'B', 'c', 'T', 't', 'C', 'b', 'B', 'C', 't', 'A', 'C', 'T', 't', 'C', 'c'};
    static ArrayList<Character> charList = new ArrayList<>(Arrays.asList('A', 'a', 'A', 'b', 'B', 'c', 'C', 'B'));

    public static void main(String[] args) {
        countSameChars(charArray);
//        на коллекціях
//        countSameChars(charList);

    }

    // масив char порахувати кількість всіх однакових char - можно використовувати інший масив
    public static void countSameChars(char[] array) {
        int[] charArray = new int[65536];

        for (int i = 0; i < array.length; i++) {
            int unicode = array[i];
            charArray[unicode] = charArray[unicode] + 1;
        }
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] > 0) {
                System.out.println((char) i +" - "+ charArray[i]);
            }

        }

    }

    public static void countSameChars(ArrayList<Character> array) {
        Map<Character, Integer> mapChar = new HashMap<>();

        for (int i = 0; i < array.size(); i++) {
            char element = array.get(i);
            if (!mapChar.containsKey(element)) {
                mapChar.put(element, 1);
            } else {
                mapChar.put(element, mapChar.get(element) + 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : mapChar.entrySet()) {
            System.out.println("Char-" + entry.getKey() + ", Кількість " + entry.getValue());
        }
    }


}
