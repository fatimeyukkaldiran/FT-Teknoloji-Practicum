package com.yukkaldiran.fatime.ftteknolojipracticum.dto.product;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;


@Data
public class ProductSaveRequestDto {

    @NotBlank(message = "The name cannot be null!")
    private String name;
    @NotNull(message = "The price cannot be null!")
    private BigDecimal price;
    private LocalDate expirationDate;
}
