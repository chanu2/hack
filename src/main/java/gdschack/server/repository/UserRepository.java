package gdschack.server.repository;

import gdschack.server.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Override
    Optional<User> findById(Long id);

    Optional<User> findByLoginId(String loginId);

    boolean existsByLoginId(String loginId);


}
