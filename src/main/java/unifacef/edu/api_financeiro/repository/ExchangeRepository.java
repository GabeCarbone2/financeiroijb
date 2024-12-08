package unifacef.edu.api_financeiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unifacef.edu.api_financeiro.models.entity.Exchange;

@Repository
public interface ExchangeRepository extends JpaRepository<Exchange, Integer> {
}
