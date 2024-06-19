package com.normdevstorm.never_give_up.mapper;
import org.mapstruct.*;
import com.normdevstorm.never_give_up.dto.ProductDto;
import com.normdevstorm.never_give_up.model.Product;


@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mappings({
            @Mapping(source = "productId", target = "productId"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "price", target = "price"),
            @Mapping(source = "imageUrl", target = "imageUrl")
    })
    ProductDto toDTO(Product product);

    @Mappings({
            @Mapping(source = "productId", target = "productId"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "price", target = "price"),
            @Mapping(source = "imageUrl", target = "imageUrl")
    })
    Product toModel(ProductDto dto);
}
