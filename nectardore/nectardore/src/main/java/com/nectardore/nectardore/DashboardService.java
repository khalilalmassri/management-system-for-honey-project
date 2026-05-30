package com.nectardore.nectardore;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Service;


@Service
public class DashboardService {
    private final SaleService saleService;
    private final ExpenseService expenseService;

    public DashboardService
            (SaleService saleService, ExpenseService expenseService){
        this.expenseService=expenseService;
        this.saleService=saleService;
    }
    public DashboardSummary getSummary(){
        double allExpense=expenseService.totalExpense();
        double totalRevenue=saleService.totalRevenue();
        double totalProfit= saleService.totalProfit();
        double netProfit=totalProfit-allExpense;
        return new DashboardSummary(    totalRevenue,
                totalProfit,
                allExpense,
                netProfit);
    }
}