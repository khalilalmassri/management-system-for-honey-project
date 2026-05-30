package com.nectardore.nectardore;

import org.springframework.web.bind.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseController{
    private final ExpenseRepository expenseRepository;
    private final ExpenseService expenseService;
    public ExpenseController(ExpenseRepository expenseRepository, ExpenseService expenseService){
        this.expenseRepository=expenseRepository;
        this.expenseService=expenseService;
    }
    @GetMapping
    public List<Expense> expenseList() {return expenseRepository.findAll();}

    @PostMapping
    public Expense createExpense(@RequestBody Expense expense){return expenseService.createExpense(expense);}

    @PutMapping("/{id}")
    public Expense updateExpense(@RequestBody Expense expense,@PathVariable Long id){
        return expenseService.updateOneExpense(expense,id);
    }

    @DeleteMapping("/{id}")
    public void deleteExpense(@PathVariable Long id){
         expenseRepository.deleteById(id);
    }
    @GetMapping("/total")
    public double getTotalExpenses(){
        return expenseService.totalExpense();
    }
}