package com.normdevstorm.never_give_up.repository;

import com.normdevstorm.never_give_up.model.Cart;
import com.normdevstorm.never_give_up.model.CartId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, CartId> {
    List<Cart> findById_UserIdOrderByProduct_ProductIdAsc(@NonNull String userId);

    @Query("select c from Cart c where c.user.id = ?1 order by c.product.productId")
    List<Cart> findByUser_IdOrderByProduct_ProductIdAsc(Long id);

}
