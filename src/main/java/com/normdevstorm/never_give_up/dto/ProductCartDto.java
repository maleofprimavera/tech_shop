package com.normdevstorm.never_give_up.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductCartDto {
    private ProductDto productDto;
    private int quantity;
}
