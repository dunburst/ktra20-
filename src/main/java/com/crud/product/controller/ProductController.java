package com.crud.product.controller;

import com.crud.product.model.Product;
import com.crud.product.model.ServiceResponse;
import com.crud.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/product")
@CrossOrigin("*")
public class ProductController {

    @Autowired
    private IProductService iProductService;

    @GetMapping("/list")
    public ResponseEntity<List<Product>> list(){
        var result = iProductService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<ServiceResponse> save(@RequestBody Product product){
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iProductService.save(product);
        if(result == 1){
            serviceResponse.setMessage("Product saved successfully");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<ServiceResponse> update(@RequestBody Product product){
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iProductService.update(product);
        if(result == 1){
            serviceResponse.setMessage("Product updated successfully");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<ServiceResponse> delete(@PathVariable int id){
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iProductService.deleteById(id);
        if(result == 1){
            serviceResponse.setMessage("Product removed successfully");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }
}
