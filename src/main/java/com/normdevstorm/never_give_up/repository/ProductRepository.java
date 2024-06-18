package com.normdevstorm.never_give_up.repository;

import com.normdevstorm.never_give_up.model.Product;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    @Query(value = "SELECT p from Product p" )
    List<Product> getAllProducts();

    @Transactional
    @Modifying
    @Query("update Product p set p.productId = ?1, p.name = ?2, p.imageUrl = ?3, p.price = ?4 where p.productId = ?5")
    int updateProductIdAndNameAndImageUrlAndPriceByProductId(@NonNull String productId, @NonNull String name, @NonNull String imageUrl, @NonNull BigDecimal price, @Nullable String productId1);

    @Query("select p from Product p where p.productId = ?1")
    Optional<Product> findByProductId(@Nullable String productId);

    @Transactional
    @Modifying
    @Query("delete from Product p where p.productId = :productId")
    int deleteByProductId(String productId);
}
