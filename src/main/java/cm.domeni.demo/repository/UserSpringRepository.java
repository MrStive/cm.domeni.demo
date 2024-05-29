package cm.domeni.demo.repository;

import cm.domeni.demo.domain.user.User;
import cm.domeni.demo.domain.user.UserId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSpringRepository extends JpaRepository<User, UserId> {
}
