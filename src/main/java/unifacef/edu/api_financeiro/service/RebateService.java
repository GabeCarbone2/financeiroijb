package unifacef.edu.api_financeiro.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unifacef.edu.api_financeiro.helpers.OptionalHelper;
import unifacef.edu.api_financeiro.mappers.ExchangeMapper;
import unifacef.edu.api_financeiro.mappers.RebateMapper;
import unifacef.edu.api_financeiro.models.dto.RebateCreateDTO;
import unifacef.edu.api_financeiro.models.dto.RebateDTO;
import unifacef.edu.api_financeiro.models.entity.Exchange;
import unifacef.edu.api_financeiro.models.entity.Rebate;
import unifacef.edu.api_financeiro.repository.RebateRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RebateService {

    @Autowired
    private RebateRepository repository;
    @Autowired
    private ExchangeService exchangeService;

    public Rebate save(Rebate rebate) {
        return repository.save(rebate);
    }

    public Rebate getById(Integer id) {
        return OptionalHelper.getOptionalEntity(repository.findById(id));
    }

    @Transactional
    public RebateDTO createRebate(RebateCreateDTO rebateCreate) {
        Rebate rebate = RebateMapper.convertRebateCreateDTOIntoRebate(rebateCreate);

        return RebateMapper.convertRebateIntoRebateDTO(save(rebate));
    }

    public List<RebateDTO> getAllRebates() {
        return RebateMapper.convertListOfRebateIntoListOfRebateDTO(repository.findAll());
    }

    @Transactional
    public RebateDTO updateRebate(RebateDTO rebateUpdate) {
        Rebate rebate = getById(rebateUpdate.getId());
        updateRetrievedEntity(rebateUpdate, rebate);

        return RebateMapper.convertRebateIntoRebateDTO(save(rebate));
    }

    @Transactional
    public void deleteRebate(Integer id) {
        Rebate rebate = getById(id);
        exchangeService.deleteExchange(rebate.getExchange().getId());
    }

    private void updateRetrievedEntity(RebateDTO rebateUpdate, Rebate rebate) {
        RebateMapper.updateRebate(rebateUpdate, rebate);
    }
}
