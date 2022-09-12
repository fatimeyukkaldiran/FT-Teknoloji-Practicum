package com.yukkaldiran.fatime.ftteknolojipracticum.entity.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yukkaldiran.fatime.ftteknolojipracticum.entity.productcomment.ProductComment;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;


@Entity
@Table(name = "PRODUCT")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
    @Id
    @GeneratedValue(generator = "Product")
    @SequenceGenerator(
            name = "Product",
            sequenceName ="PRODUCT_ID_SEQ"
    )
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "PRICE", nullable = false)
    private BigDecimal price;

    @Column(name = "EXPIRATION_DATE")
    private LocalDate expirationDate;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "product")
    private Set<ProductComment> productComments;

}
