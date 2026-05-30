package com.nectardore.nectardore;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService{
    private final ExpenseRepository expenseRepository;
    public ExpenseService(ExpenseRepository expenseRepository){this.expenseRepository=expenseRepository;}

    public Expense createExpense(Expense expense){
        return expenseRepository.save(expense);
    }
    public Expense updateOneExpense(Expense expense,Long id){
        Optional<Expense> potentialExpense= expenseRepository.findById(id);
        if(potentialExpense.isPresent()){
            Expense updatedExpense=potentialExpense.get();
            updatedExpense.setExpenseDate(expense.getExpenseDate());
            updatedExpense.setAmount(expense.getAmount());
            updatedExpense.setCategory(expense.getCategory());
            updatedExpense.setTitle(expense.getTitle());
            expenseRepository.save(updatedExpense);
        return updatedExpense;
        }
        else
            throw new RuntimeException("expense not found");
    }
    public double totalExpense(){
        double amount=0;
        List <Expense> allExpense=expenseRepository.findAll();
        for(int i=0;i<allExpense.size();i++){
            amount+=allExpense.get(i).getAmount();
        }
        return amount;
    }
            public List<Expense> expenseByCategory(String category){
        List <Expense> allExpense=expenseRepository.findAll();
        List <Expense> categoryExpense=new ArrayList<>();
        for(int i=0;i<allExpense.size();i++) {
        if (allExpense.get(i).getCategory().toLowerCase().equals(category.toLowerCase()))
            categoryExpense.add(allExpense.get(i));
        }
        if(!categoryExpense.isEmpty())
            return categoryExpense;
        else
            throw new RuntimeException("no expense is found in this category");
    }
    }
