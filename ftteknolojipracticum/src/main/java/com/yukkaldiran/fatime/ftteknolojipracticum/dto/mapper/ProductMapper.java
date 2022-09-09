package com.yukkaldiran.fatime.ftteknolojipracticum.dto.mapper;


import com.yukkaldiran.fatime.ftteknolojipracticum.dto.product.ProductDto;
import com.yukkaldiran.fatime.ftteknolojipracticum.dto.product.ProductSaveRequestDto;
import com.yukkaldiran.fatime.ftteknolojipracticum.entity.product.Product;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product convertToProduct(ProductSaveRequestDto productRequest);

    ProductDto convertToProductDto(Product product);
}
