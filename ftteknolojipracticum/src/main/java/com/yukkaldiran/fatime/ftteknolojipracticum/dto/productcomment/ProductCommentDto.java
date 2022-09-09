package com.yukkaldiran.fatime.ftteknolojipracticum.dto.productcomment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCommentDto {
    private String comment;
    private LocalDate commentDate;
}
