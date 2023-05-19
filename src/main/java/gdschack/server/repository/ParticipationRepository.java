package gdschack.server.repository;

import gdschack.server.domain.Participation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ParticipationRepository extends JpaRepository<Participation, Long> {

    List<Participation> findAllByTeacherLoginId(String teacherLoginId);

}
