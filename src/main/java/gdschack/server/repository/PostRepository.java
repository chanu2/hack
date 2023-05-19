package gdschack.server.repository;

import gdschack.server.domain.Post;
import gdschack.server.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findAllByUser(User user);

    List<Post> findAllByTeacherLoginId(String teacherLoginId);


}
