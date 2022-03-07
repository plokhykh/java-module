package lesson3.cw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ZooClub zooClub = new ZooClub();
        zooClub.addParticipant("Vasya");
        zooClub.addParticipant("Valentina");
        zooClub.addPets("Vasya", "Barsik");
        zooClub.addPets("Vasya", "Myrzik");
        zooClub.addPets("Valentina", "Myrzik");
        zooClub.addPets("Valentina", "Sharik");
//        zooClub.removeParticipant("Vasya");
//zooClub.removePetFromAllParticipants("Myrzik");
        System.out.println(zooClub);

    }
}
