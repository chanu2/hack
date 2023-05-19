package gdschack.server.dto.response;

import gdschack.server.domain.Post;
import gdschack.server.domain.User;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import static jakarta.persistence.FetchType.LAZY;

@Getter
@Data
public class PostResponse {

    private Long postId;

    private String writer;

    private String content;

    private String teacherLoginId;

    private Boolean checkRead;

    public PostResponse(Post post) {

        postId = post.getId();
        writer = post.getWriter();
        content = post.getContent();
        teacherLoginId = post.getTeacherLoginId();
        checkRead = post.getCheckRead();
    }
}
