package com.nectardore.nectardore;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleService{
    private final SaleRepository saleRepository;

    private final ProductRepository productRepository;

    public SaleService(SaleRepository saleRepository, ProductRepository productRepository){
        this.saleRepository=saleRepository;
        this.productRepository=productRepository;
    }
    public Sale newSale(Sale sale)
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
    public Sale updateOneSale(Long id, Sale sale){
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

    public double totalRevenue(){
        List<Sale> totalSale =saleRepository.findAll();
        double totalRevenue=0;
        for(int i=0;i<totalSale.size();i++){
            totalRevenue+=totalSale.get(i).getTotalPrice();
        }
        return totalRevenue;
    }


    public double totalProfit(){
        List<Sale> totalSale= saleRepository.findAll();
        double totalProfit=0;
        for(int i=0;i<totalSale.size();i++){
            Optional<Product> findProduct=productRepository.findById(totalSale.get(i).getProductId());
            if(findProduct.isPresent()){
                totalProfit+=(totalSale.get(i).getTotalPrice())-(findProduct.get().getCost() * totalSale.get(i).getQuantitySold());
            }
        }
        return totalProfit;
    }

}
