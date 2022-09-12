package com.yukkaldiran.fatime.ftteknolojipracticum.dto.productcomment;
import lombok.Data;

import javax.validation.constraints.Size;



@Data
public class CommentUpdateRequestDto  {


    private Long id;
    @Size(max=500)
    private String comment;

    private Long userId;
    private Long productId;

}
