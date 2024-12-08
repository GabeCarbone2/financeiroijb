package unifacef.edu.api_financeiro.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unifacef.edu.api_financeiro.helpers.OptionalHelper;
import unifacef.edu.api_financeiro.mappers.SaleMapper;
import unifacef.edu.api_financeiro.models.dto.SaleCreateDTO;
import unifacef.edu.api_financeiro.models.dto.SaleDTO;
import unifacef.edu.api_financeiro.models.entity.Sale;
import unifacef.edu.api_financeiro.repository.SaleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SaleService {

    @Autowired
    private SaleRepository repository;
    @Autowired
    private OutletProductService outletProductService;

    public Sale save(Sale sale) {
        return repository.save(sale);
    }

    public Sale getById(Integer id) {
        return OptionalHelper.getOptionalEntity(repository.findById(id));
    }

    @Transactional
    public SaleDTO createSale(SaleCreateDTO saleCreate) {
        Sale sale = SaleMapper.convertSaleCreateDTOIntoSale(saleCreate);

        return SaleMapper.convertSaleIntoSaleDTO(save(sale));
    }

    public List<SaleDTO> getAllSales() {
        return SaleMapper.convertListOfSaleIntoListOfSaleDTO(repository.findAll());
    }

    @Transactional
    public SaleDTO updateOutletProduct(SaleDTO saleUpdate) {
        Sale sale = getById(saleUpdate.getId());
        updateRetrievedEntity(saleUpdate, sale);

        return SaleMapper.convertSaleIntoSaleDTO(save(sale));
    }

    @Transactional
    public void deleteSale(Integer id) {
        Sale sale = getById(id);
        outletProductService.deleteOutletProduct(sale.getOutletProduct().getId());
    }

    private void updateRetrievedEntity(SaleDTO saleUpdate, Sale sale) {
        SaleMapper.updateSale(saleUpdate, sale);
    }
}
