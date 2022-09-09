package com.yukkaldiran.fatime.ftteknolojipracticum.dto.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductUpdateRequestDto {

    private String name;
    private BigDecimal price;
    private LocalDate expirationDate;

}
