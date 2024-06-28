package com.normdevstorm.never_give_up.service;
import com.normdevstorm.never_give_up.dto.ProductDto;
import com.normdevstorm.never_give_up.dto.ProductUpdateDto;
import com.normdevstorm.never_give_up.mapper.ProductMapper;
import com.normdevstorm.never_give_up.mapper.ProductMapperImpl;
import com.normdevstorm.never_give_up.model.Product;
import com.normdevstorm.never_give_up.model.ProductImage;
import com.normdevstorm.never_give_up.repository.ProductImageRepository;
import com.normdevstorm.never_give_up.repository.ProductRepository;
import com.normdevstorm.never_give_up.utils.ProductTypeEnum;
import jakarta.annotation.Nullable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    ProductImageRepository productImageRepository;
//    @Autowired
//    private ProductMapperImpl productMapper;
    @Autowired
    private ProductMapper productMapper;

    public List<ProductDto> getAllProducts() {
        List<Product> productList = productRepository.getAllProducts();
        return productList.stream().map(productMapper::toDTO).collect(Collectors.toList());
    }

    public void saveProducts(List<ProductDto> products){
        productRepository.saveAll(products.stream().map(productMapper::toModel).collect(Collectors.toList()));
    }


    public ProductDto findProductById(String id) {
       Optional<Product> filterResult = productRepository.findByProductId(id);
       if(filterResult.isEmpty()){
           return null;
       }else {
           return productMapper.toDTO(filterResult.get());
       }
    }

    public String deleteProductById(String id) {
        if(productRepository.findByProductId(id).isEmpty()){
            return "Can not find product with id: "+ id;
        }else{
            productRepository.deleteByProductId(id);
            return "Delete successfully !!!";
        }
    }

    public String updateProduct(String id, ProductUpdateDto productUpdateDto) {
        if(productRepository.findByProductId(id).isEmpty()){
            return "Can not find product with id: "+ id + "\n Update failed !!!";
        }else {
            Product product = productRepository.findByProductId(id).get();
            String name = productUpdateDto.getName();
            product.setName(name.isEmpty() ? product.getName() : name);
            BigDecimal price = productUpdateDto.getPrice();
            product.setPrice(price == null ? product.getPrice() : price);
            String imageUrl = productUpdateDto.getImageUrl();
            product.setImageUrl(imageUrl.isEmpty() ? product.getImageUrl() : imageUrl);
            String description = productUpdateDto.getDescription();
            product.setDescription(description.isEmpty() ? product.getDescription() : description);
            ProductTypeEnum productTypeEnum = productUpdateDto.getProductTypeEnum();
            product.setProductTypeEnum(productTypeEnum == null ? product.getProductTypeEnum() : productTypeEnum);
            List<ProductImage> productImages = productUpdateDto.getProductImages();
            product.setProductImages(productImages.isEmpty() ? product.getProductImages() : productImages);
            BigDecimal salePrice = productUpdateDto.getSalePrice();
            product.setSalePrice(salePrice == null ? product.getSalePrice() : salePrice);
            LocalDateTime dateCreated = LocalDateTime.now();

            if(name.isEmpty() || price == null || imageUrl.isEmpty() || productTypeEnum.describeConstable().isEmpty()){
                return "Please fill all the info";
            }else{
                productRepository.save(product);
//                List<ProductImage> images = product.getProductImages()
//                productRepository.updateProductIdAndNameAndImageUrlAndProductImagesAndPriceAndSalePriceAndDescriptionAndProductTypeEnumAndDateCreatedByProductIdLike(product.getProductId(), product.getName(), product.getImageUrl(), product.getProductImages(),product.getPrice() ,product.getSalePrice() ,product.getDescription() ,product.getProductTypeEnum() ,product.getDateCreated() ,product.getProductId());
//                productRepository.updateProductIdAndNameAndImageUrlAndPriceByProductId(productId, name, imageUrl, price, id);
                return "Updated successfully !!!";
            }

        }
    }
}
