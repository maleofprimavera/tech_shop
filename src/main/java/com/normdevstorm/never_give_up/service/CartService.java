package com.normdevstorm.never_give_up.service;

import com.normdevstorm.never_give_up.dto.ProductDto;
import com.normdevstorm.never_give_up.mapper.ProductMapper;
import com.normdevstorm.never_give_up.model.Cart;
import com.normdevstorm.never_give_up.model.Product;
import com.normdevstorm.never_give_up.repository.CartRepository;
import com.normdevstorm.never_give_up.repository.ProductRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Mutability;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private ProductMapper productMapper;

    public List<ProductDto> addProductsToCart(String cartId, String productId) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new RuntimeException("Cart not found"));
        Product product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));
        List<Product> productList = cart.getProductList();
        boolean existed =
                cart.getProductList().stream().anyMatch(existedProduct -> existedProduct.getProductId().contentEquals(productId)) && !productList.isEmpty();
        if (existed) throw new RuntimeException("Product existed in cart!!!");
        productList.add(product);
        cart.setProductList(productList);
        cartRepository.save(cart);
        return productList.stream().map(productMapper::toDTO).collect(Collectors.toList());
    }

    public String removeProductFromCart(String cartId, String productId) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new RuntimeException("Cart not found"));
        Product soonDeletedProduct = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));
        boolean existed =
                cart.getProductList().stream().anyMatch(existedProduct -> existedProduct.getProductId().contentEquals(productId)) && !cart.getProductList().isEmpty();
        if (!existed) throw new RuntimeException("Product not found in cart!!!");
        cartRepository.updateProductListByIdLike(cartId, productId);
        return "Deleted successfully!!!";
    }

    public List<ProductDto> getProductsFromCart(String cartId) {
    Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new RuntimeException("Cart not found"));
    return cart.getProductList().stream().map(productMapper::toDTO).collect(Collectors.toList());
    }}
