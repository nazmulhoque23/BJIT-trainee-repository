package com.bjit.exceptions.exceptionhandler.controller;

import com.bjit.exceptions.exceptionhandler.exception.CategoryException;
import com.bjit.exceptions.exceptionhandler.model.Category;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    List<Category> categories = new ArrayList<>();
    @PostMapping("/add-category")
    public void addCategory(@RequestBody Category category){
        //System.out.println(category.getCategoryId() + category.getCategoryName());
        categories.add(category);

    }
    @GetMapping("/get-category/{name}")
    public ResponseEntity<Object> getCategory(@PathVariable String name){
        for(Category category: categories){
            System.out.println(category.getCategoryName());
            if(category.getCategoryName().equals(name)){
                return new ResponseEntity<>(category, HttpStatus.OK);
            }
        }
        throw new CategoryException("Category Not found");
    }
    @GetMapping("/get-all")
    public ResponseEntity<Object> getAllCategory(){
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
}
