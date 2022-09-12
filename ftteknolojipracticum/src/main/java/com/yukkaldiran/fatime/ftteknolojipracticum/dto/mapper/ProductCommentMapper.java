package com.yukkaldiran.fatime.ftteknolojipracticum.dto.mapper;

import com.yukkaldiran.fatime.ftteknolojipracticum.dto.productcomment.ProductCommentDto;
import com.yukkaldiran.fatime.ftteknolojipracticum.entity.productcomment.ProductComment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductCommentMapper {

     ProductCommentDto convertToCommentDto(ProductComment comment);
}
