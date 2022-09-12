package com.yukkaldiran.fatime.ftteknolojipracticum.dto.productcomment;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class CommentSaveRequestDto {

    @Size(max=500)
    private String comment;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate commentDate;

    private Long UserId;
    private Long productId;
}
