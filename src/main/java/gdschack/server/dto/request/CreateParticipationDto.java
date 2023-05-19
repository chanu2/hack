package gdschack.server.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateParticipationDto {

    private String loginId;

    private String teacherLoginId;
}
