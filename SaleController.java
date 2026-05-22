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

    private final ProductRepository productRepository;

    public SaleController(SaleRepository saleRepository, ProductRepository productRepository){
        this.saleRepository=saleRepository;
        this.productRepository=productRepository;
    }

    @GetMapping
    public List<Sale> getAllSales(){ return saleRepository.findAll();}

    @PostMapping
    public Sale createNewSale(@RequestBody Sale sale)
    {
        Long idToFind= sale.getProductId();
        Optional<Product> findProduct=productRepository.findById(idToFind);
        if(findProduct.isPresent()){
            Product checkProduct= findProduct.get();
            if(checkProduct.getStock()>=sale.getQuantitySold()){
                checkProduct.setStock(checkProduct.getStock()-sale.getQuantitySold());
                productRepository.save(checkProduct);
                sale.setTotalPrice(sale.getQuantitySold()*checkProduct.getSellingPrice());
                return saleRepository.save(sale) ;
            }else{
                throw new RuntimeException("Not enough stock available");
            }

        }else{
            throw new RuntimeException("Product not found");
        }

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
