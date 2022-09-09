package com.yukkaldiran.fatime.ftteknolojipracticum.entity.productcomment;

import com.yukkaldiran.fatime.ftteknolojipracticum.entity.product.Product;
import com.yukkaldiran.fatime.ftteknolojipracticum.entity.user.User;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "PRODUCT_COMMENT")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductComment {
    @Id
    @GeneratedValue(generator = "ProductComment")
    @SequenceGenerator(
            name = "ProductComment",
            sequenceName = "PRODUCT_COMMENT_ID_SEQ"
    )
    private Long id;

    @Column(name = "COMMENT", length = 500, nullable = false)
    private String comment;

    @Column(name = "COMMENT_DATE")
    private LocalDate commentDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "PRODUCT_ID",
            foreignKey = @ForeignKey(name = "FK_PRODUCT_COMMENT"),
            nullable = false)
    private Product productId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "USER_ID",
            foreignKey = @ForeignKey(name = "FK_USER_COMMENT"),
            nullable = false)
    private User userId;


}
