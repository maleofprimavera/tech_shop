package com.normdevstorm.never_give_up.dto;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO for {@link com.normdevstorm.never_give_up.model.Product}
 */
@Getter
@Setter
@AllArgsConstructor
@Value
public class ProductDto implements Serializable {
    @NotNull
    @Size(max = 255)
    String productId;
    @NotNull
    @Size(max = 255)
    String name;
    @Size(max = 2083)
    String imageUrl;
    @NotNull
    BigDecimal price;
}