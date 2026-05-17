package com.nectardore.nectardore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;
    private int size;
    private double cost;
    private double sellingPrice;
    private int stock;

    public Product() {
    }

    public Product(String name, int size, double cost, double sellingPrice, int stock) {
        this.name = name;
        this.size = size;
        this.cost = cost;
        this.sellingPrice = sellingPrice;
        this.stock = stock;
    }

    @Override
    public String toString(){
        return "the honey "+this.name+" of size "+this.size+" and cost "+this.cost+" and stock "
                +this.stock+" and selling price "+ this.sellingPrice+" was just created";
    }

    public void setName(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setSize(int size){
        this.size=size;
    }

    public int getSize() {
        return size;
    }

    public void setCost(double cost){
        this.cost=cost;
    }
    public double getCost(){
        return cost;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice){
        this.sellingPrice=sellingPrice;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock){
        this.stock=stock;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}