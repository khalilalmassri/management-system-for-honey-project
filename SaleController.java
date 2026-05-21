package com.nectardore.nectardore;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sales")
public class SaleController{

    private final SaleRepository saleRepository;

    public SaleController(SaleRepository saleRepository){ this.saleRepository=saleRepository;    }

    @GetMapping
    public List<Sale> getAllSales(){ return saleRepository.findAll();}

    @PostMapping
    public Sale createNewSale(@RequestBody Sale sale){
        return saleRepository.save(sale);
    }

    @DeleteMapping("/{id}")
    public void deleteSaleById(@PathVariable Long id){saleRepository.deleteById(id);}

    @PutMapping("/{id}")
    public Sale updateSale(@PathVariable Long id, @RequestBody Sale sale){
    Optional<Sale> found = saleRepository.findById(id);
    if(found.isPresent()){
        Sale existing =found.get();
    existing.setQuantitySold(sale.getQuantitySold());
    existing.setTotalPrice(sale.getTotalPrice());
    saleRepository.save(existing);
        return existing;
    }
    else {
        throw new RuntimeException("sale with this id not found!");
    }
    }

}