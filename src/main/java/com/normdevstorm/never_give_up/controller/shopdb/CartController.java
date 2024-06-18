package com.normdevstorm.never_give_up.controller.shopdb;

import com.normdevstorm.never_give_up.dto.CartDto;
import com.normdevstorm.never_give_up.dto.ProductDto;
import com.normdevstorm.never_give_up.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/{userId}")
    public CartDto getCart(@PathVariable(name = "userId") String userId){
        return cartService.getCart(userId);
    }
}
