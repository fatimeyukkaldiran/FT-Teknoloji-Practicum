package com.yukkaldiran.fatime.ftteknolojipracticum.dto.converter;

import antlr.collections.impl.LList;
import com.yukkaldiran.fatime.ftteknolojipracticum.dto.product.ProductDto;
import com.yukkaldiran.fatime.ftteknolojipracticum.entity.product.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class ProductConverter {
    public ProductDto convertToProductDto(Product from){
        return new ProductDto(
                from.getId(),
                from.getName(),
                from.getPrice(),
                from.getExpirationDate()
        );
    }
    public List<ProductDto> convertToProductDtoList(List<Product> products){
        return products
                .stream()
                .map(this::convertToProductDto)
                .collect(Collectors.toList());
    }
}
