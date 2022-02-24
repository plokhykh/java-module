package lesson3.hw;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        ArrayList<Skill> skills1 = new ArrayList<>();
        skills1.add(new Skill(SkillsEnum.java, 10));
        Car car1 = new Car("toyota", 2015, 300);

        ArrayList<Skill> skills2 = new ArrayList<>();
        skills2.add(new Skill(SkillsEnum.js, 1));
        skills2.add(new Skill(SkillsEnum.php, 5));
        Car car2 = new Car("mazda", 2018, 250);

        ArrayList<Skill> skills3 = new ArrayList<>();
        skills3.add(new Skill(SkillsEnum.php, 3));
        skills3.add(new Skill(SkillsEnum.fortran, 2));
        skills3.add(new Skill(SkillsEnum.go, 1));
        skills3.add(new Skill(SkillsEnum.java, 1));
        Car car3 = new Car("audi", 2010, 200);

        ArrayList<Skill> skills4 = new ArrayList<>();
        skills4.add(new Skill(SkillsEnum.js, 3));
        skills4.add(new Skill(SkillsEnum.java, 8));
        skills4.add(new Skill(SkillsEnum.ruby, 2));
        Car car4 = new Car("bmw", 2020, 350);

        ArrayList<Skill> skills5 = new ArrayList<>();
        skills5.add(new Skill(SkillsEnum.python, 3));
        skills5.add(new Skill(SkillsEnum.java, 1));
        Car car5 = new Car("ford", 2017, 200);

        ArrayList<Skill> skills6 = new ArrayList<>();
        skills6.add(new Skill(SkillsEnum.go, 2));
        skills6.add(new Skill(SkillsEnum.ruby, 5));
        Car car6 = new Car("lexus", 2016, 250);

        ArrayList<Skill> skills7 = new ArrayList<>();
        skills7.add(new Skill(SkillsEnum.js, 2));
        Car car7 = new Car("mercedes", 2012, 200);

        ArrayList<Skill> skills8 = new ArrayList<>();
        skills8.add(new Skill(SkillsEnum.fortran, 5));
        Car car8 = new Car("toyota", 2019, 300);

        ArrayList<Skill> skills9 = new ArrayList<>();
        skills9.add(new Skill(SkillsEnum.go, 1));
        skills9.add(new Skill(SkillsEnum.python, 5));
        skills9.add(new Skill(SkillsEnum.java, 3));
        Car car9 = new Car("ford", 2018, 300);

        ArrayList<Skill> skills10 = new ArrayList<>();
        skills10.add(new Skill(SkillsEnum.fortran, 5));
        skills10.add(new Skill(SkillsEnum.php, 2));
        skills10.add(new Skill(SkillsEnum.js, 3));
        skills10.add(new Skill(SkillsEnum.python, 1));
        Car car10 = new Car("audi", 2017, 250);

        HashSet<User> usersHash = new HashSet<>();
//        usersHash.add(new User(1, "Andrey", "Sarnavski", "qwerty@gmail.com", 31, Gender.MALE, skills1, car1));
//        usersHash.add(new User(2, "Anastasia", "Samandasuk", "qwerty@gmail.com", 26, Gender.FEMALE, skills2, car2));
//        usersHash.add(new User(3, "Elena", "Donchuk", "qwerty@gmail.com", 20, Gender.FEMALE, skills3, car3));
//        usersHash.add(new User(4, "Anton", "Tymanskiy", "qwerty@gmail.com", 35, Gender.MALE, skills4, car4));
//        usersHash.add(new User(5, "Igor", "Bygaenko", "qwerty@gmail.com", 28, Gender.MALE, skills5, car5));
//        usersHash.add(new User(6, "Alena", "Rudenko", "qwerty@gmail.com", 29, Gender.FEMALE, skills6, car6));
//        usersHash.add(new User(7, "Polina", "Shkreba", "qwerty@gmail.com", 24, Gender.FEMALE, skills7, car7));
//        usersHash.add(new User(8, "Max", "Polyakov", "qwerty@gmail.com", 30, Gender.MALE, skills8, car8));
//        usersHash.add(new User(9, "Artur", "Shkil", "qwerty@gmail.com", 25, Gender.MALE, skills9, car9));
//        usersHash.add(new User(10, "Vasya", "Kononenko", "qwerty@gmail.com", 32, Gender.MALE, skills10, car10));

        Iterator<User> iterator = usersHash.iterator();

        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getGender() == Gender.MALE) {
                iterator.remove();
            }
        }

        System.out.println(usersHash);


        TreeSet<User> userTreeSet = new TreeSet<>();
        userTreeSet.add(new User(1, "Andrey", "Sarnavski", "qwerty@gmail.com", 31, Gender.MALE, skills1, car1));
        userTreeSet.add(new User(2, "Anastasia", "Samandasuk", "qwerty@gmail.com", 26, Gender.FEMALE, skills2, car2));
        userTreeSet.add(new User(3, "Elena", "Donchuk", "qwerty@gmail.com", 20, Gender.FEMALE, skills3, car3));
        userTreeSet.add(new User(4, "Anton", "Tymanskiy", "qwerty@gmail.com", 35, Gender.MALE, skills4, car4));
        userTreeSet.add(new User(5, "Igor", "Bygaenko", "qwerty@gmail.com", 28, Gender.MALE, skills5, car5));
        userTreeSet.add(new User(6, "Alena", "Rudenko", "qwerty@gmail.com", 29, Gender.FEMALE, skills6, car6));
        userTreeSet.add(new User(7, "Polina", "Shkreba", "qwerty@gmail.com", 24, Gender.FEMALE, skills7, car7));
        userTreeSet.add(new User(8, "Max", "Polyakov", "qwerty@gmail.com", 30, Gender.MALE, skills8, car8));
        userTreeSet.add(new User(9, "Artur", "Shkil", "qwerty@gmail.com", 25, Gender.MALE, skills9, car9));
        userTreeSet.add(new User(10, "Vasya", "Kononenko", "qwerty@gmail.com", 32, Gender.MALE, skills10, car10));

        System.out.println(userTreeSet);
    }
}
