//package gdschack.server.global;
//
//import gdschack.server.domain.Post;
//import gdschack.server.domain.User;
//import jakarta.annotation.PostConstruct;
//import jakarta.persistence.EntityManager;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.time.LocalDateTime;
//
//@Component  // 스프링빈 등록
//@RequiredArgsConstructor
//public class InitDb {
//
//    private final InitService initService;
//
//    @PostConstruct  //bean이 여러 번 초기화되는 걸 방지할 수 있다.
//    public void init() {
//        initService.dbInit1();
//    }
//
//    @Component
//    @Transactional
//    @RequiredArgsConstructor // 생성자 주입
//    static class InitService {
//
//        private final EntityManager em;
//
//        public void dbInit1() {
//
//            User user1 = User.builder().name("이진우").loginId("asd").phoneNum("010").workPlace(null).status("학생").build();
//            User user2 = User.builder().name("김찬우").loginId("qwe").phoneNum("0109").workPlace(null).status("학생").build();
//            User user3 = User.builder().name("이유리").loginId("zxc").phoneNum("011").workPlace(null).status("학생").build();
//            User user4 = User.builder().name("유쥰성").loginId("jkl").phoneNum("012").workPlace("대광중").status("선생님").build();
//            User user5 = User.builder().name("유쥰성").loginId("ljsdf").phoneNum("014").workPlace("대광고").status("선생님").build();
//
//            em.persist(user1);
//            em.persist(user2);
//            em.persist(user3);
//            em.persist(user4);
//            em.persist(user5);
//
//            Post post1 = Post.builder().user(user1).content("안녕하세요").writer("a").teacherLoginId("jkl").build();
//            Post post2 = Post.builder().user(user2).content("안녕하세요1").writer("b").teacherLoginId("jkl").build();
//            Post post3 = Post.builder().user(user3).content("안녕하세요2").writer("c").teacherLoginId("jkl").build();
//            Post post4 = Post.builder().user(user4).content("안녕하세요3").writer("d").teacherLoginId("jkl").build();
//
//            em.persist(post1);
//            em.persist(post2);
//            em.persist(post3);
//            em.persist(post4);
//
//
//            em.flush();
//
//            em.clear();
//
//
//        }
//
//
//
//
//    }
//}

