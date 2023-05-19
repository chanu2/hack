package gdschack.server.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostCreateDto {

    private String loginId;

    private String content;

    private String teacherLoginId;

    private String writer;

}
