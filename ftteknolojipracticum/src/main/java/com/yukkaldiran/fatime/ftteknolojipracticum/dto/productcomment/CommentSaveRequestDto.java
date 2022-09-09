package com.yukkaldiran.fatime.ftteknolojipracticum.dto.productcomment;

import lombok.Data;
import java.time.LocalDate;

@Data
public class CommentSaveRequestDto {

    private String comment;
    private LocalDate commentDate;
    private Long UserId;
    private Long productId;
}
