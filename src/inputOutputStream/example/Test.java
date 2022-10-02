package inputOutputStream.example;

import tasks.Array;

import java.io.*;
import java.util.*;

public class Test {
    public static void main(String[] args) throws IOException {
//        Scanner sc1 = new Scanner(System.in);
//        Scanner sc2 = new Scanner(System.in);
//        int x1 = sc1.nextInt();
//        int x2 = sc2.nextInt();
//        sc1.close();
//        System.in.read();//Exception in thread "main" java.io.IOException: Stream closed

        try (Scanner scanner = new Scanner(new File("/Users/Marina/IdeaProjects/java-module/test.txt"))) {
           int stringCounter = 0;
           int integerCounter = 0;
           int doubleCounter = 0;

            while (scanner.hasNextLine()) {
                if (scanner.hasNextInt()) {
                    int intValue = scanner.nextInt();
                    integerCounter++;
                } else if (scanner.hasNextDouble()) {
                    double doubleValue = scanner.nextDouble();
                    doubleCounter++;
                } else if (scanner.hasNext()) {
                    String strValue = scanner.next();
                    stringCounter++;
                }
        }

        System.out.println("string Counter " + stringCounter);
        System.out.println("integer Counter " + integerCounter);
        System.out.println("double Counter " + doubleCounter);
        }

    }
}
