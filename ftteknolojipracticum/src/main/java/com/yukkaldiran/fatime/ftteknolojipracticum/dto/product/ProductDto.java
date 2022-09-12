package com.yukkaldiran.fatime.ftteknolojipracticum.dto.product;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.yukkaldiran.fatime.ftteknolojipracticum.dto.productcomment.ProductCommentDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private  Long id;
    private String name;
    private BigDecimal price;
    private LocalDate expirationDate;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ProductCommentDto> comments = new ArrayList<>();
}
