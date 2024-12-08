package unifacef.edu.api_financeiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unifacef.edu.api_financeiro.models.entity.OutletProduct;

import java.util.List;

@Repository
public interface OutletProductRepository  extends JpaRepository<OutletProduct, Integer> {
    List<OutletProduct> findAllByOutletProductName(String outletProductName);

    List<OutletProduct> findAllByOutletProductDescription(String outletProductDescription);
}
