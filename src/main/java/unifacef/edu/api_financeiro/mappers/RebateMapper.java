package unifacef.edu.api_financeiro.mappers;

import org.springframework.stereotype.Component;
import unifacef.edu.api_financeiro.models.dto.RebateCreateDTO;
import unifacef.edu.api_financeiro.models.dto.RebateDTO;
import unifacef.edu.api_financeiro.models.entity.Rebate;

import java.util.ArrayList;
import java.util.List;

@Component
public class RebateMapper {
    public static Rebate convertRebateCreateDTOIntoRebate(RebateCreateDTO rebateCreate) {
        return new Rebate(ExchangeMapper.convertExchangeCreateDTOIntoExchange(rebateCreate.getExchange()),
                rebateCreate.getDescription(), rebateCreate.getRebateValue());
    }

    public static RebateDTO convertRebateIntoRebateDTO(Rebate rebate) {
        return new RebateDTO(rebate.getId(), ExchangeMapper.convertExchangeIntoExchangeDTO(rebate.getExchange()),
                rebate.getDescription(), rebate.getRebateValue());
    }

    public static List<RebateDTO> convertListOfRebateIntoListOfRebateDTO(List<Rebate> rebates) {
        List<RebateDTO> rebateDTOs = new ArrayList<>();

        for (Rebate rebate : rebates) {
            rebateDTOs.add(convertRebateIntoRebateDTO(rebate));
        }

        return rebateDTOs;
    }

    public static void updateRebate(RebateDTO rebateUpdate, Rebate rebate) {
        rebate.setExchange(ExchangeMapper.convertExchangeDTOIntoExchange(rebateUpdate.getExchange()));
        rebate.setDescription(rebateUpdate.getDescription());
        rebate.setRebateValue(rebateUpdate.getRebateValue());
    }
}
