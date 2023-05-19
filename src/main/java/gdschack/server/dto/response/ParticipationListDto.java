package gdschack.server.dto.response;


import gdschack.server.domain.Participation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParticipationListDto {

    private String name;

    public ParticipationListDto(Participation participation) {
        name = participation.getUser().getName();
    }
}
