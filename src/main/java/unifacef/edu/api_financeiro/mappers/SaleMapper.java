package unifacef.edu.api_financeiro.mappers;

import org.springframework.stereotype.Component;
import unifacef.edu.api_financeiro.models.dto.SaleCreateDTO;
import unifacef.edu.api_financeiro.models.dto.SaleDTO;
import unifacef.edu.api_financeiro.models.entity.Sale;

import java.util.ArrayList;
import java.util.List;

@Component
public class SaleMapper {

    public static Sale convertSaleCreateDTOIntoSale(SaleCreateDTO saleCreate) {
        return new Sale(OutletProductMapper
                .convertOutletProductCreateDTOIntoOutletProduct(saleCreate.getOutletProduct()),
                saleCreate.getSaleValue(), saleCreate.getSaleDescription());
    }

    public static SaleDTO convertSaleIntoSaleDTO(Sale sale) {
        return new SaleDTO(sale.getId(),
                OutletProductMapper.convertOutletProductIntoOutletProductDTO(sale.getOutletProduct()),
                sale.getSaleValue(), sale.getSaleDescription());
    }

    public static List<SaleDTO> convertListOfSaleIntoListOfSaleDTO(List<Sale> sales) {
        List<SaleDTO> saleDTOs = new ArrayList<>();

        for (Sale sale : sales) {
            saleDTOs.add(convertSaleIntoSaleDTO(sale));
        }

        return saleDTOs;
    }

    public static void updateSale(SaleDTO saleUpdate, Sale sale) {
        sale.setOutletProduct(OutletProductMapper
                .convertOutletProductDTOIntoOutletProduct(saleUpdate.getOutletProduct()));
        sale.setSaleValue(saleUpdate.getSaleValue());
        sale.setSaleDescription(saleUpdate.getSaleDescription());

    }
}
