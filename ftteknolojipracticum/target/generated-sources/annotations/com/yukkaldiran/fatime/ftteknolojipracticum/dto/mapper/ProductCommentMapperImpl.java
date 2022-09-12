package com.yukkaldiran.fatime.ftteknolojipracticum.dto.mapper;

import com.yukkaldiran.fatime.ftteknolojipracticum.dto.productcomment.ProductCommentDto;
import com.yukkaldiran.fatime.ftteknolojipracticum.entity.productcomment.ProductComment;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-12T05:02:16+0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.4 (Oracle Corporation)"
)
@Component
public class ProductCommentMapperImpl implements ProductCommentMapper {

    @Override
    public ProductCommentDto convertToCommentDto(ProductComment comment) {
        if ( comment == null ) {
            return null;
        }

        ProductCommentDto productCommentDto = new ProductCommentDto();

        productCommentDto.setId( comment.getId() );
        productCommentDto.setComment( comment.getComment() );
        productCommentDto.setCommentDate( comment.getCommentDate() );
        productCommentDto.setProduct( comment.getProduct() );
        productCommentDto.setUser( comment.getUser() );

        return productCommentDto;
    }
}
