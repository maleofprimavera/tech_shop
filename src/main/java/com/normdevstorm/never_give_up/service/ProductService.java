package com.normdevstorm.never_give_up.service;
import com.normdevstorm.never_give_up.dto.ProductDto;
import com.normdevstorm.never_give_up.mapper.ProductMapper;
import com.normdevstorm.never_give_up.mapper.ProductMapperImpl;
import com.normdevstorm.never_give_up.model.Product;
import com.normdevstorm.never_give_up.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
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

    public String updateProduct(String id, ProductDto productDto) {
        if(productRepository.findByProductId(id).isEmpty()){
            return "Can not find product with id: "+ id + "\n Update failed !!!";
        }else {
            String productId = productDto.getProductId();
            String name = productDto.getName();
            BigDecimal price = productDto.getPrice();
            String imageUrl = productDto.getImageUrl();
            if(productId.isEmpty() || name.isEmpty() || price == null || imageUrl.isEmpty()){
                return "Please fill all the info";
            }else{
                productRepository.updateProductIdAndNameAndImageUrlAndPriceByProductId(productId, name, imageUrl, price, id);
                return "Updated successfully !!!";
            }

        }
    }
}
