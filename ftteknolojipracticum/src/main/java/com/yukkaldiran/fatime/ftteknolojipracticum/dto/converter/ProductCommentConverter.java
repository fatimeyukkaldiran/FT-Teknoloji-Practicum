package com.yukkaldiran.fatime.ftteknolojipracticum.dto.converter;

import com.yukkaldiran.fatime.ftteknolojipracticum.dto.product.ProductDto;
import com.yukkaldiran.fatime.ftteknolojipracticum.dto.productcomment.ProductCommentDto;
import com.yukkaldiran.fatime.ftteknolojipracticum.entity.productcomment.ProductComment;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductCommentConverter {

    public ProductCommentDto convertToProductCommentDto(ProductComment from){
        return new ProductCommentDto(
                from.getId(),
                from.getComment(),
                from.getCommentDate(),
                from.getProduct(),
                from.getUser()

        );
    }
    public List<ProductCommentDto> convertToProductCommentDtoList(List<ProductComment> comments){
        return comments
                .stream()
                .map(this::convertToProductCommentDto)
                .collect(Collectors.toList());
    }
}
