package com.yukkaldiran.fatime.ftteknolojipracticum.dto.productcomment;
import lombok.Data;

import java.time.LocalDate;


@Data
public class CommentUpdateRequestDto  {


    private Long id;
    private String comment;
    private LocalDate commentDate;
    private Long userId;
    private Long productId;

}
