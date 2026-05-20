package com.nectardore.nectardore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;


@Entity
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productId;
    private int quantitySold;
    private double totalPrice;
    private LocalDateTime saleDate;

    public Sale() {
    }

    public Sale(Long productId,int quantitySold, double totalPrice) {
        this.productId=productId;
        this.quantitySold = quantitySold;
        this.totalPrice = totalPrice;
        this.saleDate= LocalDateTime.now();
    }
    @Override
    public String toString(){
        return "the product of id " + productId + " was sold, in quantity of "+quantitySold
                +" and total price "+totalPrice+" at the date: "+saleDate;
    }
    public Long getProductId(){ return productId;}
    public void setProductId(Long productId){
        this.productId=productId;
    }

    public void setQuantitySold(int quantitySold){
        this.quantitySold=quantitySold;
    }
    public int getQuantitySold(){ return quantitySold;}

    public void setTotalPrice(double totalPrice){
        this.totalPrice=totalPrice;
    }
    public double getTotalPrice(){ return totalPrice;}

    public LocalDateTime getSaleDate(){return saleDate;}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
