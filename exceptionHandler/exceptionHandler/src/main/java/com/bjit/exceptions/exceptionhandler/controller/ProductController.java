package com.bjit.exceptions.exceptionhandler.controller;

import com.bjit.exceptions.exceptionhandler.exception.ProductException;
import com.bjit.exceptions.exceptionhandler.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    List<Product> products  = new ArrayList<>();
    @PostMapping("/add-products")
    public void addProduct(@RequestBody Product product){
        products.add(product);
    }
    @GetMapping("/get-product/{id}")
    public ResponseEntity<Object> getProduct(@PathVariable Integer id){
        for(Product product: products){
            if(product.getId().equals(id)){
                return new ResponseEntity<>(product, HttpStatus.OK);
            }
        }
        throw new ProductException("Product Not found");

    }

    @GetMapping("/get-all")
    public ResponseEntity<Object> getAllProduct(){
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
