package lesson1;

public class Main {

    public static void main(String[] args) {
        Post article = new Post(1, 3, "title", "body");
        Comment comment = new Comment(
                1,
                1,
                "id labore ex et quam laborum",
                "Eliseo@gardner.biz",
                "laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium"
        );


        System.out.println(article);
    }
}
