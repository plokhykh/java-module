package lesson1.cw;

public class Main {
    public static void main(String[] args) {

        Geo geo = new Geo("-37.3159", "81.1496");
        Address address = new Address(
                "Kulas Light",
                "Apt. 556",
                "Gwenborough",
                "92998-3874", geo);

        Company company = new Company(
                "Romaguera-Crona",
                "Multi-layered client-server neural-net",
                "harness real-time e-markets");


        User newUser = new User(
                2,
                "Leanne Graham",
                "Bret",
                "Sincere@april.biz",
                "1-770-736-8031 x56442",
                "hildegard.org",
                address,
                company);

        System.out.println(newUser);
    }
}
