package unifacef.edu.api_financeiro.mappers;

import org.springframework.stereotype.Component;
import unifacef.edu.api_financeiro.models.dto.PurchasedMaterialCreateDTO;
import unifacef.edu.api_financeiro.models.dto.PurchasedMaterialDTO;
import unifacef.edu.api_financeiro.models.entity.PurchasedMaterial;

import java.util.ArrayList;
import java.util.List;

@Component
public class PurchasedMaterialMapper {
    public static PurchasedMaterial convertPurchasedMaterialCreateDTOIntoPurchasedMaterial(
            PurchasedMaterialCreateDTO purchasedMaterialCreate) {
        return new PurchasedMaterial(
                purchasedMaterialCreate.getMaterialName(),
                Integer.parseInt(String.valueOf(purchasedMaterialCreate.getMaterialQuantity()))

        );
    }

    public static PurchasedMaterialDTO convertPurchasedMaterialIntoPurchasedMaterialDTO(PurchasedMaterial purchasedMaterial) {
        return new PurchasedMaterialDTO(
                purchasedMaterial.getId(),
                purchasedMaterial.getMaterialName(),
                purchasedMaterial.getMaterialQuantity()
        );
    }

    public static List<PurchasedMaterialDTO> convertListOfPurchasedMaterialIntoListOfPurchasedMaterialDTO(
            List<PurchasedMaterial> purchasedMaterials) {
        List<PurchasedMaterialDTO> purchasedMaterialDTOs = new ArrayList<>();

        for (PurchasedMaterial purchasedMaterial : purchasedMaterials) {
            purchasedMaterialDTOs.add(convertPurchasedMaterialIntoPurchasedMaterialDTO(purchasedMaterial));
        }

        return purchasedMaterialDTOs;
    }

    public static void updatePurchasedMaterial(PurchasedMaterialDTO purchasedMaterialUpdate, PurchasedMaterial purchasedMaterial) {
        purchasedMaterial.setMaterialName(purchasedMaterialUpdate.getMaterialName());
        purchasedMaterial.setMaterialQuantity(purchasedMaterialUpdate.getMaterialQuantity());
    }

    public static PurchasedMaterial convertPurchasedMaterialDTOIntoPurchasedMaterial(PurchasedMaterialDTO purchasedMaterialDTO) {
        return new PurchasedMaterial(
                purchasedMaterialDTO.getMaterialName(),
                purchasedMaterialDTO.getMaterialQuantity()
        );
    }
}
