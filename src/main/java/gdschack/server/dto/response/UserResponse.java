package gdschack.server.dto.response;

import gdschack.server.domain.User;
import lombok.Getter;


@Getter
public class UserResponse {
    private Long userId;

    private String name;

    private String phoneNum;

    private String loginId;

    private String workPlace;

    private boolean status;

    public UserResponse(User user) {
        this.userId = user.getId();
        this.name = user.getName();
        this.phoneNum = user.getPhoneNum();
        this.loginId = user.getLoginId();
        this.workPlace = user.getWorkPlace();
        this.status = user.getStatus();
    }
}
