package gdschack.server.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdatePostDto {

    private Long postId;

    private String loginId;

    private String content;

}
