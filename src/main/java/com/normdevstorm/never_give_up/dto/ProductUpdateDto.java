package com.normdevstorm.never_give_up.dto;

import com.normdevstorm.never_give_up.model.ProductImage;
import com.normdevstorm.never_give_up.utils.ProductTypeEnum;
import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * DTO for {@link com.normdevstorm.never_give_up.model.Product}
 */
@Getter
@Setter
@AllArgsConstructor
@Value
public class ProductUpdateDto implements Serializable {
    @NotNull
    @Size(max = 255)
    String name;
    @Size(max = 2083)
    String imageUrl;
    @NotNull
    BigDecimal price;
    @Nullable
    String description;
    @NotNull
    @Enumerated(EnumType.STRING)
    ProductTypeEnum productTypeEnum;
    private List<ProductImage> productImages;
    private BigDecimal salePrice;
}