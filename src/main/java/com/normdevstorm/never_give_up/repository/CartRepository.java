package com.normdevstorm.never_give_up.repository;

import com.normdevstorm.never_give_up.model.Cart;
import com.normdevstorm.never_give_up.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CartRepository extends JpaRepository<Cart, String> {
    @Transactional
    @Modifying
    @Query(value = "delete from cart_product_list c where c.id = ?1 and c.product_id like ?2", nativeQuery = true)
    int updateProductListByIdLike(String cartId, String id);
}
