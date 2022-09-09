package com.yukkaldiran.fatime.ftteknolojipracticum.repository.product;

import com.yukkaldiran.fatime.ftteknolojipracticum.entity.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByExpirationDateOrExpirationDateAfter(LocalDate o, LocalDate now);

    List<Product> findByExpirationDateBefore(LocalDate now);



}
