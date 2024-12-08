package unifacef.edu.api_financeiro.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unifacef.edu.api_financeiro.helpers.OptionalHelper;
import unifacef.edu.api_financeiro.mappers.DonationMapper;
import unifacef.edu.api_financeiro.mappers.OutletProductMapper;
import unifacef.edu.api_financeiro.models.dto.OutletProductCreateDTO;
import unifacef.edu.api_financeiro.models.dto.OutletProductDTO;
import unifacef.edu.api_financeiro.models.entity.Donation;
import unifacef.edu.api_financeiro.models.entity.OutletProduct;
import unifacef.edu.api_financeiro.models.enums.OutletProductStatus;
import unifacef.edu.api_financeiro.repository.OutletProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OutletProductService {

    @Autowired
    private OutletProductRepository repository;

    public OutletProduct save(OutletProduct outletProduct) {
        return repository.save(outletProduct);
    }

    public OutletProduct getById(Integer id) {
        return OptionalHelper.getOptionalEntity(repository.findById(id));
    }

    @Transactional
    public OutletProductDTO createOutletProduct(OutletProductCreateDTO outletProductCreate) {
        OutletProduct outletProduct = OutletProductMapper
                .convertOutletProductCreateDTOIntoOutletProduct(outletProductCreate);

        return OutletProductMapper.convertOutletProductIntoOutletProductDTO(save(outletProduct));
    }

    public List<OutletProductDTO> getAllOutletProducts() {
        return OutletProductMapper.convertListOfOutletProductIntoListOfOutletProductDTO(repository.findAll());
    }

    public List<OutletProductDTO> getAllOutletProductsByFilter(String nameOrDescription) {
        List<OutletProduct> outletProducts = repository.findAllByOutletProductName(nameOrDescription);
        if (!outletProducts.isEmpty()) {
            return OutletProductMapper.convertListOfOutletProductIntoListOfOutletProductDTO(outletProducts);
        }

        outletProducts = repository.findAllByOutletProductDescription(nameOrDescription);
        if(!outletProducts.isEmpty()) {
            return OutletProductMapper.convertListOfOutletProductIntoListOfOutletProductDTO(outletProducts);
        }

        throw new EntityNotFoundException("There aren't products with this name/description");
    }

    @Transactional
    public OutletProductDTO updateOutletProduct(OutletProductDTO outletProductUpdate) {
        OutletProduct outletProduct = getById(outletProductUpdate.getId());
        updateRetrievedEntity(outletProductUpdate, outletProduct);

        return OutletProductMapper.convertOutletProductIntoOutletProductDTO(save(outletProduct));
    }

    @Transactional
    public void deleteOutletProduct(Integer id) {
        OutletProduct outletProduct = getById(id);
        save(changeOutletProductStatus(OutletProductStatus.INACTIVE, outletProduct));
    }

    private void updateRetrievedEntity(OutletProductDTO outletProductUpdate, OutletProduct outletProduct) {
        OutletProductMapper.updateOutletProduct(outletProductUpdate, outletProduct);
    }

    private OutletProduct changeOutletProductStatus(OutletProductStatus status, OutletProduct outletProduct) {
        outletProduct.setStatus(status);

        return outletProduct;
    }
}
