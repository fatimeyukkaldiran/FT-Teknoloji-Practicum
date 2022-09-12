package com.yukkaldiran.fatime.ftteknolojipracticum.entity.user;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yukkaldiran.fatime.ftteknolojipracticum.entity.productcomment.ProductComment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Set;

@Entity
@Table(name ="USER")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(generator = "User")
    @SequenceGenerator(
            name = "User",
    sequenceName = "USER_ID_SEQ"
    )
    private Long id;

    @Column(name = "NAME", length = 50, nullable = false)
    private String name;

    @Column(name = "SURNAME", length = 50, nullable = false)
    private String surname;

    @Email
    @Column(name = "EMAIL", length = 50, nullable = false)
    private String email;


    @Column(name = "TELEPHONE", length = 15, nullable = false)
    private String phoneNumber;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "user")
    private Set<ProductComment> productComments;

}
