package com.yukkaldiran.fatime.ftteknolojipracticum.service.productcomment;

import com.yukkaldiran.fatime.ftteknolojipracticum.dto.converter.ProductCommentConverter;
import com.yukkaldiran.fatime.ftteknolojipracticum.dto.mapper.ProductCommentMapper;
import com.yukkaldiran.fatime.ftteknolojipracticum.dto.productcomment.CommentSaveRequestDto;
import com.yukkaldiran.fatime.ftteknolojipracticum.dto.productcomment.ProductCommentDto;
import com.yukkaldiran.fatime.ftteknolojipracticum.entity.product.Product;
import com.yukkaldiran.fatime.ftteknolojipracticum.entity.productcomment.ProductComment;
import com.yukkaldiran.fatime.ftteknolojipracticum.entity.user.User;
import com.yukkaldiran.fatime.ftteknolojipracticum.exception.ProductNotFoundException;
import com.yukkaldiran.fatime.ftteknolojipracticum.repository.product.ProductRepository;
import com.yukkaldiran.fatime.ftteknolojipracticum.repository.productcomment.ProductCommentRepository;
import com.yukkaldiran.fatime.ftteknolojipracticum.service.product.ProductService;
import com.yukkaldiran.fatime.ftteknolojipracticum.service.user.UserService;
import com.yukkaldiran.fatime.ftteknolojipracticum.utils.ErrorMessageConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductCommentService {
    private final ProductRepository productRepository;
    private final ProductCommentRepository commentRepository;
    private final ProductService productService;
    private final UserService userService;
    private final ProductCommentConverter converter;
    private final ProductCommentMapper mapper;


    public ProductCommentDto saveComment(CommentSaveRequestDto requestDto) {
        User user = userService.findUserById(requestDto.getUserId());
        Product product = productService.findProductById(requestDto.getProductId());

        ProductComment comment = new ProductComment(
                null,
                requestDto.getComment(),
                requestDto.getCommentDate(),
                product,
                user
        );
        return mapper.convertToCommentDto(comment);
    }

    public List<ProductCommentDto> getComments() {
        return converter.convertToProductCommentDtoList(commentRepository.findAll());
    }

    public List<ProductCommentDto> getCommentsByProductId(Long productId) {
        Product product = productService.findProductById(productId);
        List<ProductComment> comments = commentRepository.findAllByProductId(product.getId());
        return converter.convertToProductCommentDtoList(comments);
    }

    public List<ProductCommentDto> getCommentsByProductIdAndBetweenTwoDates(Long productId, String fromStr, String toStr) {
        LocalDate from = LocalDate.parse(fromStr);
        LocalDate to = LocalDate.parse(toStr);
        Product product = productService.findProductById(productId);
        List<ProductComment> comments = commentRepository.findProductCommentsByProductIdAndCommentDateBetween(product.getId(), from, to);
        return converter.convertToProductCommentDtoList(comments);

    }
    public List<ProductCommentDto> getCommentsByUserIdAndBetweenTwoDates(Long userId, String fromStr, String toStr) {
        LocalDate from = LocalDate.parse(fromStr);
        LocalDate to = LocalDate.parse(toStr);
        User user = userService.findUserById(userId);
        List<ProductComment> comments = commentRepository.findAllByUserIdAndCommentDateBetween(user.getId(), from, to);
        return converter.convertToProductCommentDtoList(comments);

    }

    public List<ProductCommentDto> getCommentsByUserId(Long userId) {
        User  user = userService.findUserById(userId);
        List<ProductComment> comments = commentRepository.findAllByUserId(user.getId());
        return converter.convertToProductCommentDtoList(comments);
    }
}
