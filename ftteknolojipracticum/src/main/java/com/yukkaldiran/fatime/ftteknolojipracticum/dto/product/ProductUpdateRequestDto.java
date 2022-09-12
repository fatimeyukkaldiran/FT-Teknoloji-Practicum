package com.yukkaldiran.fatime.ftteknolojipracticum.dto.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductUpdateRequestDto {

    @NotBlank
    private String name;
    @NotNull
    private BigDecimal price;

    private LocalDate expirationDate;

}
