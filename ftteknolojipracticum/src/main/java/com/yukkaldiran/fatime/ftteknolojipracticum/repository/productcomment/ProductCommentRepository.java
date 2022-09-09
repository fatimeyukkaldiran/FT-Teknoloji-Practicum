package com.yukkaldiran.fatime.ftteknolojipracticum.repository.productcomment;
import com.yukkaldiran.fatime.ftteknolojipracticum.entity.productcomment.ProductComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ProductCommentRepository extends JpaRepository<ProductComment,Long> {

    List<ProductComment> findAllByProductId(Long productId);
    List<ProductComment> findProductCommentsByProductIdAndCommentDateBetween(Long productId, LocalDate from, LocalDate to);
    List<ProductComment> findAllByUserIdAndCommentDateBetween(Long userId, LocalDate from, LocalDate to);
    List<ProductComment> findAllByUserId(Long userId);
}
