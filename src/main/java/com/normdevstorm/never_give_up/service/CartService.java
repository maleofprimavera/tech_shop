package com.normdevstorm.never_give_up.service;

import com.normdevstorm.never_give_up.dto.CartDto;
import com.normdevstorm.never_give_up.dto.ProductCartDto;
import com.normdevstorm.never_give_up.dto.ProductDto;
import com.normdevstorm.never_give_up.mapper.ProductMapper;
import com.normdevstorm.never_give_up.model.Cart;
import com.normdevstorm.never_give_up.repository.CartRepository;
import com.normdevstorm.never_give_up.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;

    public CartDto getCart(String userId) {
        //check if user_id exist
        //true -> get prodIds => new entity(prod, quantity)
        List<Cart> cartList = cartRepository.findById_UserIdOrderByProduct_ProductIdAsc(userId);
        if (!cartList.isEmpty()) {

            List<ProductCartDto> productCartDtoList = cartList.stream().map(cart -> new ProductCartDto(productMapper.toDTO(productRepository.findByProductId(cart.getId().getProductId()).get()), cart.getQuantity())).toList();
            return new CartDto(userId, productCartDtoList);
        } else {
            return null;
        }
    }
}
