package gdschack.server.global;

import gdschack.server.domain.User;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Component  // 스프링빈 등록
@RequiredArgsConstructor
public class InitDb {

    private final InitService initService;

    @PostConstruct  //bean이 여러 번 초기화되는 걸 방지할 수 있다.
    public void init() {
        initService.dbInit1();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor // 생성자 주입
    static class InitService {

        private final EntityManager em;

        public void dbInit1() {

            User user1 = User.builder().name("이진우").loginId("1").phoneNum("010").workPlace(null).status(false).build();
            User user2 = User.builder().name("김찬우").loginId("2").phoneNum("0109").workPlace(null).status(false).build();
            User user3 = User.builder().name("이유리").loginId("3").phoneNum("011").workPlace(null).status(false).build();
            User user4 = User.builder().name("유쥰성").loginId("4").phoneNum("012").workPlace("대광중").status(true).build();


            em.persist(user1);
            em.persist(user2);
            em.persist(user3);
            em.persist(user4);


            em.flush();

            em.clear();


        }




    }
}

