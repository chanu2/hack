package gdschack.server.dto.request;


import gdschack.server.domain.User;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class UserCreateDto {

    private String name;

    private String phoneNum;

    private String loginId;

    private String workPlace;

    private boolean status;

    public User toEntity() {
        return User.builder()
                .name(name)
                .phoneNum(phoneNum)
                .loginId(loginId)
                .workPlace(workPlace)
                .status(status)
                .build();
    }

}
