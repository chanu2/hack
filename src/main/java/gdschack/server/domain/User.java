package gdschack.server.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private String name;

    private String phoneNum;

    private String loginId;

    private String workPlace;

    private boolean status;

    @Builder
    public User( String name, String phoneNum, String loginId, String workPlace, boolean status) {
        this.name = name;
        this.phoneNum = phoneNum;
        this.loginId = loginId;
        this.workPlace = workPlace;
        this.status = status;
    }


}
