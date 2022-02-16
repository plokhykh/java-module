package lesson1.hw;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString


public class Post {
    private int userId;
    private int id;
    private String title;
    private String body;

}
