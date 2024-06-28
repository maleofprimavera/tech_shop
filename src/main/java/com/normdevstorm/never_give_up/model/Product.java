package com.normdevstorm.never_give_up.model;

import com.normdevstorm.never_give_up.utils.ProductTypeEnum;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "product", schema = "shopdb")
public class Product {
    @Id
    @Size(max = 255)
    @Column(nullable = false)
    private String productId;

    @Size(max = 255)
    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Size(max = 2083)
    @Column(length = 2083)
    private String imageUrl;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true  )
    private List<ProductImage> productImages;

    @NotNull
    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(nullable = true, precision = 10, scale = 2)
    private BigDecimal salePrice;

    @Column(name = "description", nullable = true)
    private String description;
    @NotNull
    @Enumerated(EnumType.STRING)
    private ProductTypeEnum productTypeEnum;
    private LocalDateTime dateCreated;


}