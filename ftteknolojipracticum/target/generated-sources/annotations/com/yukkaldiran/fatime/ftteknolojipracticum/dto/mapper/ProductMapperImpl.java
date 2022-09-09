package com.yukkaldiran.fatime.ftteknolojipracticum.dto.mapper;

import com.yukkaldiran.fatime.ftteknolojipracticum.dto.product.ProductDto;
import com.yukkaldiran.fatime.ftteknolojipracticum.dto.product.ProductSaveRequestDto;
import com.yukkaldiran.fatime.ftteknolojipracticum.entity.product.Product;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-09T09:52:24+0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.4 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product convertToProduct(ProductSaveRequestDto productRequest) {
        if ( productRequest == null ) {
            return null;
        }

        Product product = new Product();

        product.setName( productRequest.getName() );
        product.setPrice( productRequest.getPrice() );
        product.setExpirationDate( productRequest.getExpirationDate() );

        return product;
    }

    @Override
    public ProductDto convertToProductDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setId( product.getId() );
        productDto.setName( product.getName() );
        productDto.setPrice( product.getPrice() );
        productDto.setExpirationDate( product.getExpirationDate() );

        return productDto;
    }
}
