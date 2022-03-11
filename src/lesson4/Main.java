package lesson4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<User> users = new ArrayList<>();
        users.add(new User(1, "Vasya", 35));
        users.add(new User(2, "Katya", 22));
        users.add(new User(3, "Valentina", 16));
        users.add(new User(4, "Igor", 28));
        users.add(new User(5, "Max", 19));
        users.add(new User(6, "Aleksey", 39));
        users.add(new User(7, "Bogdan", 41));

        //sorted by age
        //DESC
//        users.sort(((o1, o2) -> o2.getAge() - o1.getAge()));
        //ASC
//        users.sort(((o1, o2) -> o1.getAge() - o2.getAge()));

        //sorted by name
        users.sort((o1, o2) -> o2.getName().length() - o1.getName().length());
        users.sort((o1, o2) -> o1.getName().length() - o2.getName().length());
//        System.out.println(users);


        List<String> words = new ArrayList<>();
        words.add("advance");
        words.add("dinner");
        words.add("content");
        words.add("line");
        words.add("rain");
        words.add("blue");
        words.add("include");
        words.add("anybody");
        words.add("pain");
        words.add("moon");
        words.add("scale");
        words.add("successfully");
        words.add("wife");
        words.add("yellow");
        words.add("terrible");
        words.add("restaurant");
        words.add("window");
        words.add("strategic");
        words.add("universal");
        words.add("tomorrow");

        List<String> filtredWords = words.stream()
                .sorted((o1, o2) -> o1.compareTo(o2))
                .filter(word -> word.length() > 4)
                .collect(Collectors.toList());
        System.out.println(filtredWords);

        List<Integer> intArray = new ArrayList<>();
        intArray.add(123);
        intArray.add(40);
        intArray.add(1500);
        intArray.add(3);
        intArray.add(28);
        intArray.add(105);
        intArray.add(1030);
        intArray.add(12);
        intArray.add(57);
        intArray.add(999);
        intArray.add(100500);
        intArray.add(345);
        intArray.add(93);
        intArray.add(78);
        intArray.add(593);
        intArray.add(1398);
        intArray.add(0);
        intArray.add(293);
        intArray.add(37);
        intArray.add(97);


        List<Integer> multipleOfThree = intArray.stream()
                .sorted((o1, o2) -> o2 - o1)
                .filter(integer -> integer % 3 == 0)
                .collect(Collectors.toList());
        System.out.println(multipleOfThree);

//        intArray.stream()
//                .sorted((o1, o2) -> o1-o2)
//                .filter(integer -> integer % 10 == 0)
//                .forEach(System.out::println);

        List<Integer> threeTimesMore =
                intArray.stream()
                        .map(integer ->  integer * 3)
                        .collect(Collectors.toList());
        System.out.println(threeTimesMore);
    }
}
