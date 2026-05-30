package com.nectardore.nectardore;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/sales")
public class SaleController{

    private final SaleRepository saleRepository;

    private final ProductRepository productRepository;

    private final SaleService saleService;

    public SaleController(SaleRepository saleRepository, ProductRepository productRepository, SaleService saleService){
        this.saleRepository=saleRepository;
        this.productRepository=productRepository;
        this.saleService=saleService;
    }


    @GetMapping
    public List<Sale> getAllSales(){ return saleRepository.findAll();}

    @PostMapping
    public Sale createNewSale(@RequestBody Sale sale)
    {return saleService.newSale(sale);
    }

    @DeleteMapping("/{id}")
    public void deleteSaleById(@PathVariable Long id){saleRepository.deleteById(id);}

    @PutMapping("/{id}")
    public Sale updateSale(@PathVariable Long id, @RequestBody Sale sale){
    return saleService.updateOneSale(id,sale);
    }

    @GetMapping("/total-revenue")
    public double getTotalRevenue(){
        return saleService.totalRevenue();
    }


    @GetMapping("/total-profit")
    public double getTotalProfit(){
        return saleService.totalProfit();
    }
    
    @GetMapping("/date")
    public List<Sale> saleByDate(@RequestParam LocalDate date){
        return saleService.saleByDate(date);
    }
}
