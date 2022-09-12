package com.yukkaldiran.fatime.ftteknolojipracticum.entity.productcomment;

import com.yukkaldiran.fatime.ftteknolojipracticum.entity.product.Product;
import com.yukkaldiran.fatime.ftteknolojipracticum.entity.user.User;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "PRODUCT_COMMENT")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate commentDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "PRODUCT_ID",
            foreignKey = @ForeignKey(name = "FK_PRODUCT_COMMENT"),
            nullable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "USER_ID",
            foreignKey = @ForeignKey(name = "FK_USER_COMMENT"),
            nullable = false)
    private User user;


}
