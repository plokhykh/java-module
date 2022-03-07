package lesson3.cw;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

@Data
@AllArgsConstructor
public class ZooClub {
    private Map<Person, List<Pet>> club;

    public ZooClub() {
        club = new HashMap<>();
    }

    public Map<Person, List<Pet>> getMap() {
        return club;
    }

    public void addParticipant(String name) {
        this.club.put(new Person(name), new ArrayList<>());
    }

    public void addPets(String ownerName, String petName) {
        this.club.get(new Person(ownerName)).add(new Pet(petName));
    }

    public void removePet(String ownerName, String petName) {
        this.club.get(new Person(ownerName)).remove(this.club.get(new Person(ownerName)).indexOf(new Pet(petName)));
    }

    public void removeParticipant(String name) {
        this.club.remove(new Person(name));
    }

    public void removePetFromAllParticipants(String petName) {
        Set<Person> keySet = this.club.keySet();
        for (Person key : keySet) {
            Iterator<Pet> iter = this.club.get(key).iterator();
            while (iter.hasNext()) {
                Pet pet = iter.next();
                if (pet.getName().equals(petName)) {
                    iter.remove();
                }
            }
        }

    }
}
