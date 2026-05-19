package com.nectardore.nectardore;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController{

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }
        @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Long id){
        productRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id,@RequestBody Product updatedProduct){
        Optional<Product> found = productRepository.findById(id);
        if(found.isPresent()){
            Product existing = found.get();
            existing.setName(updatedProduct.getName());
            existing.setCost(updatedProduct.getCost());
            existing.setSize(updatedProduct.getSize());
            existing.setStock(updatedProduct.getStock());
            existing.setSellingPrice(updatedProduct.getSellingPrice());
            productRepository.save(existing);
            return existing;
        } else {
            throw new RuntimeException("product with id not found");
        }
    }
}
