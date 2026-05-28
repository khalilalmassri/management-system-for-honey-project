package com.nectardore.nectardore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Entity public class Expense {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
private String title;
private String category;
private LocalDateTime expenseDate;
private double amount;

public Expense(){}

    public Expense(String title, String category, LocalDateTime expenseDate,double amount){
    this.title=title;
    this.expenseDate=expenseDate;
    this.category=category;
    this.amount=amount;
    }

    @Override
    public String toString(){
    return "the expense "+title+" of category "+category+" and total amount "+amount+" was created at: "+expenseDate;
    }
    public String getTitle(){return title;}
    public void setTitle(String title){this.title=title;}
    
    public String getCategory(){return category;}
    public void setCategory(String category){this.category=category;}
    
    public double getAmount(){return amount;}
    public void setAmount(double amount){this.amount=amount;}
    
    public LocalDateTime getExpenseDate(){return expenseDate;}
    public void setExpenseDate(LocalDateTime expenseDate){this.expenseDate=expenseDate;}
    
    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}
}
