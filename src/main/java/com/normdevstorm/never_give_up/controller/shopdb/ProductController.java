package com.normdevstorm.never_give_up.controller.shopdb;

import com.normdevstorm.never_give_up.dto.ProductDto;
import com.normdevstorm.never_give_up.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ProductDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/add")
    public void addProduct(@RequestBody List<ProductDto> products){
        productService.saveProducts(products);
    }

    @GetMapping("/filter-by-id/{id}")
    public ProductDto findProductById(@PathVariable("id") String id)
    {
        return productService.findProductById(id);
    }

    @DeleteMapping("/delete-by-id/{id}")
    public String deleteById(@PathVariable("id") String id){
        return productService.deleteProductById(id);
    }

    @PatchMapping("/update-product")
    public String updateStudent(@RequestParam String id,
                              @RequestBody ProductDto productDto){
        return productService.updateProduct(id, productDto);
    }


}

