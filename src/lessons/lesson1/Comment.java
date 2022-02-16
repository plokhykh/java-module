package lessons.lesson1;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString


public class Comment {
    int postId;
    int id;
    String name;
    String email;
    String body;
}

