package com.abhishek.API;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/product")
public class ProductController {

          @Autowired
          private ProductService productService;

          @PostMapping("/add")
          public ResponseEntity<?> addProduct(@RequestBody Product product) {
                    return productService.addProduct(product);
          }

          @GetMapping("/get")
          public ResponseEntity<List<Product>> GetProducts() {
                    return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.FOUND);
          }

          @GetMapping("/get/{id}")
          public ResponseEntity<Product> GetProductById(@PathVariable String id) {
                    return new ResponseEntity<>(productService.GetProductById(id), HttpStatus.FOUND);
          }
}
