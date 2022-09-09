package com.yukkaldiran.fatime.ftteknolojipracticum.dto.product;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;


@Data
public class ProductSaveRequestDto {

    private String name;
    private BigDecimal price;
    private LocalDate expirationDate;
}
