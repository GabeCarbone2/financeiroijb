package unifacef.edu.api_financeiro.repository;

import org.springframework.stereotype.Repository;
import unifacef.edu.api_financeiro.models.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}
