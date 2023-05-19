package gdschack.server.dto.response;

import lombok.Getter;

@Getter
public class LoginCheck {
    boolean exists;

    public LoginCheck(boolean exists) {
        this.exists = exists;
    }
}