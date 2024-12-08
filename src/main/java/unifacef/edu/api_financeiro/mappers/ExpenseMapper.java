package unifacef.edu.api_financeiro.mappers;

import org.springframework.stereotype.Component;
import unifacef.edu.api_financeiro.models.dto.ExpenseDTO;
import unifacef.edu.api_financeiro.models.entity.Expense;

import java.util.ArrayList;
import java.util.List;

@Component
public class ExpenseMapper {
    public static Expense convertExpenseDTOIntoExpense(ExpenseDTO expenseDTO){
        return new Expense(
                PurchasedMaterialMapper.convertPurchasedMaterialDTOIntoPurchasedMaterial(expenseDTO.getPurchasedMaterialDTO()),
                ConstructionMapper.convertConstructionDTOToEntity(expenseDTO.getConstructionDTO()),
                expenseDTO.getReceiptDate(),
                expenseDTO.getExpiryDate()
        );
    }

    public static ExpenseDTO convertExpenseIntoExpenseDTO(Expense expense){
        return new ExpenseDTO(
                expense.getId(),
                PurchasedMaterialMapper.convertPurchasedMaterialIntoPurchasedMaterialDTO(expense.getPurchasedMaterial()),
                ConstructionMapper. convertConstructionEntityToDTO(expense.getConstruction()),
                expense.getReceiptDate(),
                expense.getExpiryDate()
        );
    }

    public static List<ExpenseDTO> convertListOfExpenseIntoListOfExpenseDTO(List<Expense> expenses) {
        List<ExpenseDTO> expenseDTOs = new ArrayList<>();
        for (Expense expense : expenses) {
            expenseDTOs.add(convertExpenseIntoExpenseDTO(expense));
        }
        return expenseDTOs;
    }

    public static void updateExpense(ExpenseDTO expenseUpdate, Expense expense) {
        expense.setPurchasedMaterial(PurchasedMaterialMapper.convertPurchasedMaterialDTOIntoPurchasedMaterial(expenseUpdate.getPurchasedMaterialDTO()));
        expense.setConstruction(ConstructionMapper.convertConstructionDTOToEntity(expenseUpdate.getConstructionDTO()));
        expense.setReceiptDate(expenseUpdate.getReceiptDate());
        expense.setExpiryDate(expenseUpdate.getExpiryDate());
    }


}
