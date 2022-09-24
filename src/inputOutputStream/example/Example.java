package inputOutputStream.example;


import java.io.*;
import java.util.ArrayList;


public class Example {

    /*Ввести с консоли имя файла.
Найти байт или байты с максимальным количеством повторов.
Вывести их на экран через пробел.
Закрыть поток ввода-вывода.**/
    public void getMaxByteFromFile() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] byteArr = new int[256];
        try (FileInputStream file = new FileInputStream(reader.readLine())) {
            while (file.available() > 0) {
                byteArr[file.read()] += 1;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int maxByte = Integer.MIN_VALUE;
        for (int value : byteArr) {
            if (value > maxByte) maxByte = value;
        }
        ArrayList<Integer> resultArr = new ArrayList<>();
        for (int i = 0; i < byteArr.length; i++) {
            if (byteArr[i] == maxByte) resultArr.add(i);
        }
        resultArr.forEach(item -> System.out.print(item + " "));
    }

    /*Ввести с консоли имя файла.
Найти байт или байты с минимальным количеством повторов.
Вывести их на экран через пробел.
Закрыть поток ввода-вывода.**/
    public void getMinByteFromFile() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] byteCountArray = new int[256];

        try (FileInputStream file = new FileInputStream(reader.readLine())) {
            while (file.available() > 0) {
                byteCountArray[file.read()] += 1;
            }
        }

        int minCount = Integer.MAX_VALUE;
        for (int byteCount : byteCountArray) {
            if (byteCount > 0 && byteCount < minCount) minCount = byteCount;
        }
        ArrayList<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < byteCountArray.length; i++) {
            if (byteCountArray[i] == minCount) resultList.add(i);
        }
        for (Integer resultItem : resultList) System.out.print(resultItem + " ");
    }


}
