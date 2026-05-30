package com.nectardore.nectardore;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){this.productRepository=productRepository;}

    public List<Product> lowStockProduct(){
        List<Product> allProducts= productRepository.findAll();
        List<Product> lowStockProducts= new ArrayList<>();
        for(int i=0; i<allProducts.size();i++){
            if(allProducts.get(i).getStock()<=5) {
            lowStockProducts.add(allProducts.get(i));
            }
        }
        return lowStockProducts;
    }

    public List<Product> searchProductByName(String name){
        List<Product> findProduct=productRepository.findAll();
        List<Product> foundProduct=new ArrayList<>();
        for(int i=0;i<findProduct.size();i++) {
            if (findProduct.get(i).getName().toLowerCase().contains(name.toLowerCase()))
                foundProduct.add(findProduct.get(i));
        }
        if (!foundProduct.isEmpty())
            return foundProduct;
        else
            throw new RuntimeException("not found");
    }

}