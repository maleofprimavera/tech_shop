package com.normdevstorm.never_give_up.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
public class CartDto {
    private String userId;
    private List<ProductCartDto> productCartList;
}
