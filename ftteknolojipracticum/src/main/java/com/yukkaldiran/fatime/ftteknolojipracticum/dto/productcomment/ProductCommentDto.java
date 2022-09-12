package com.yukkaldiran.fatime.ftteknolojipracticum.dto.productcomment;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.yukkaldiran.fatime.ftteknolojipracticum.entity.product.Product;
import com.yukkaldiran.fatime.ftteknolojipracticum.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCommentDto {
    private Long Id;
    private String comment;
    private LocalDate commentDate;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Product product;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private User user;
}
