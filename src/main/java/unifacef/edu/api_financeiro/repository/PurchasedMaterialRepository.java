package unifacef.edu.api_financeiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unifacef.edu.api_financeiro.models.entity.PurchasedMaterial;

import java.util.List;

@Repository
public interface PurchasedMaterialRepository extends JpaRepository<PurchasedMaterial, Integer> {
    List<PurchasedMaterial> findAllByMaterialName(String name);
}
