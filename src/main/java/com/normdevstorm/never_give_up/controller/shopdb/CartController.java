package com.normdevstorm.never_give_up.controller.shopdb;

import com.normdevstorm.never_give_up.dto.ProductDto;
import com.normdevstorm.never_give_up.service.CartService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/cart/{cartId}/add/{productId}")
    public List<ProductDto> addProductToCart(@PathVariable("cartId") String cartId, @PathVariable("productId") String productId){
        return cartService.addProductsToCart(cartId,productId);
    }

    @CrossOrigin(origins = "http://localhost:58261")
    @DeleteMapping("/cart/{cartId}/delete/{productId}")
    public String removeProductFromCart(@PathVariable("cartId") String cartId, @PathVariable("productId") String productId){
        return cartService.removeProductFromCart(cartId,productId);
    }

    @GetMapping("/cart/{cartId}/all")
        public List<ProductDto> getProductsFromCart(@PathVariable("cartId") String cartId){
            return cartService.getProductsFromCart(cartId);
        }


}
