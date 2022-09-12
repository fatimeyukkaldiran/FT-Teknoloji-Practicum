package com.yukkaldiran.fatime.ftteknolojipracticum.controller.productcomment;

import com.yukkaldiran.fatime.ftteknolojipracticum.dto.product.ProductDto;
import com.yukkaldiran.fatime.ftteknolojipracticum.dto.product.ProductUpdateRequestDto;
import com.yukkaldiran.fatime.ftteknolojipracticum.dto.productcomment.CommentSaveRequestDto;
import com.yukkaldiran.fatime.ftteknolojipracticum.dto.productcomment.CommentUpdateRequestDto;
import com.yukkaldiran.fatime.ftteknolojipracticum.dto.productcomment.ProductCommentDto;
import com.yukkaldiran.fatime.ftteknolojipracticum.entity.productcomment.ProductComment;
import com.yukkaldiran.fatime.ftteknolojipracticum.service.productcomment.ProductCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(path = "api/v1/comment")
@RequiredArgsConstructor
public class ProductCommentController {

    private final ProductCommentService commentService;

    @GetMapping()
    public ResponseEntity<List<ProductCommentDto>> findAll(){
      List<ProductCommentDto> commentDtoList = commentService.getComments();
        return new ResponseEntity<>(commentDtoList, HttpStatus.OK);
    }
    @GetMapping("/{commentId}")
    public ResponseEntity<ProductCommentDto> getComment(@PathVariable Long commentId){
        ProductCommentDto comment= commentService.getCommentById(commentId);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<ProductCommentDto> save(@Valid @RequestBody CommentSaveRequestDto saveRequestDto){
        ProductCommentDto commentDto = commentService.saveComment(saveRequestDto);
        return new ResponseEntity<>(commentDto, HttpStatus.OK);
    }
    @GetMapping(path="/product/{productId}")
    public ResponseEntity<List<ProductCommentDto>> getAllProductComments(@PathVariable("productId") Long productId){
        List<ProductCommentDto> commentDtoList = commentService.getCommentsByProductId(productId);
        return new ResponseEntity<>(commentDtoList, HttpStatus.OK);
    }

    @GetMapping(path="/product/{productId}/comments")
    public ResponseEntity<List<ProductCommentDto>> findByProductIdAndCommentDateBetween(
            @PathVariable("productId") Long productId,
            @RequestParam(value = "from",required = true) String fromStr,
            @RequestParam(value = "to",required = true) String toStr){

        List<ProductCommentDto> comments = commentService.getCommentsByProductIdAndBetweenTwoDate(productId, fromStr, toStr);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @GetMapping(path="/user/{userId}/comments")
    public ResponseEntity<List<ProductCommentDto>> findByUserIdAndCommentDateBetween(
            @PathVariable("userId") Long userId,
            @RequestParam(value = "from",required = true) String fromStr,
            @RequestParam(value = "to",required = true) String toStr){

        List<ProductCommentDto> comments = commentService.getCommentsByUserIdAndBetweenTwoDate(userId, fromStr, toStr);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @GetMapping(path="/user/{userId}")
    public ResponseEntity<List<ProductCommentDto>> findAllUserComments(@PathVariable("userId") Long userId){
        List<ProductCommentDto> commentDtoList = commentService.getCommentsByUserId(userId);
        return new ResponseEntity<>(commentDtoList, HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<ProductCommentDto> updateComment(@Valid @RequestBody CommentUpdateRequestDto updateCommentRequest){
        ProductCommentDto commentDto = commentService.updateComment(updateCommentRequest);
        return new ResponseEntity<>(commentDto, HttpStatus.OK);
    }

    @DeleteMapping(path="/{commentId}")
    public ResponseEntity<String> deleteProduct(@PathVariable("commentId") Long commentId){
        String result = commentService.deleteComment(commentId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


}
