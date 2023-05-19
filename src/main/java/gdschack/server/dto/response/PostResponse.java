package gdschack.server.dto.response;

import gdschack.server.domain.User;
import jakarta.persistence.*;
import lombok.Getter;

import static jakarta.persistence.FetchType.LAZY;

@Getter
public class PostResponse {

    private Long postId;

    private String writer;

    private String content;

    private Long teacherId;

}
