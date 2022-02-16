package lesson1.hw;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Comment {
    private int postId;
    private int id;
    private String name;
    private String email;
    private String body;
}

