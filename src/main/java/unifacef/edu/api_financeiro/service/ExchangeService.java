package unifacef.edu.api_financeiro.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unifacef.edu.api_financeiro.helpers.OptionalHelper;
import unifacef.edu.api_financeiro.mappers.ExchangeMapper;
import unifacef.edu.api_financeiro.mappers.OutletProductMapper;
import unifacef.edu.api_financeiro.models.dto.ExchangeCreateDTO;
import unifacef.edu.api_financeiro.models.dto.ExchangeDTO;
import unifacef.edu.api_financeiro.models.entity.Exchange;
import unifacef.edu.api_financeiro.models.entity.OutletProduct;
import unifacef.edu.api_financeiro.repository.ExchangeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ExchangeService {

    @Autowired
    private ExchangeRepository repository;
    @Autowired
    private OutletProductService outletProductService;

    public Exchange save(Exchange exchange) {
        return repository.save(exchange);
    }

    public Exchange getById(Integer id) {
        return OptionalHelper.getOptionalEntity(repository.findById(id));
    }

    @Transactional
    public ExchangeDTO createExchange(ExchangeCreateDTO exchangeCreate) {
        Exchange exchange = ExchangeMapper.convertExchangeCreateDTOIntoExchange(exchangeCreate);

        return ExchangeMapper.convertExchangeIntoExchangeDTO(save(exchange));
    }

    public List<ExchangeDTO> getAllExchanges() {
        return ExchangeMapper.convertListOfExchangeIntoListOfExchangeDTO(repository.findAll());
    }

    @Transactional
    public ExchangeDTO updateExchange(ExchangeDTO exchangeUpdate) {
        Exchange exchange = getById(exchangeUpdate.getId());
        updateRetrievedEntity(exchangeUpdate, exchange);

        return ExchangeMapper.convertExchangeIntoExchangeDTO(save(exchange));
    }

    @Transactional
    public void deleteExchange(Integer id) {
        Exchange exchange = getById(id);
        outletProductService.deleteOutletProduct(exchange.getOutletProduct().getId());
    }

    private void updateRetrievedEntity(ExchangeDTO exchangeUpdate, Exchange exchange) {
        ExchangeMapper.updateExchange(exchangeUpdate, exchange);
    }
}
