package gdschack.server.domain;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String writer;

    private String content;

    private String teacherLoginId;


    @Builder
    public Post( User user, String writer, String content,String teacherLoginId) {
        this.user = user;
        this.writer = writer;
        this.content = content;
        this.teacherLoginId =teacherLoginId;
    }
}
