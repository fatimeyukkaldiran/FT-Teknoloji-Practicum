package com.yukkaldiran.fatime.ftteknolojipracticum.controller.productcomment;

import com.yukkaldiran.fatime.ftteknolojipracticum.dto.productcomment.CommentSaveRequestDto;
import com.yukkaldiran.fatime.ftteknolojipracticum.dto.productcomment.ProductCommentDto;
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

    @PostMapping()
    public ResponseEntity<ProductCommentDto> save(@Valid @RequestBody CommentSaveRequestDto saveRequestDto){
        ProductCommentDto commentDto = commentService.saveComment(saveRequestDto);
        return new ResponseEntity<>(commentDto, HttpStatus.OK);
    }
    @GetMapping(path="/{productId}")
    public ResponseEntity<List<ProductCommentDto>> getAllProductComments(@PathVariable("productId") Long productId){
        List<ProductCommentDto> commentDtoList = commentService.getCommentsByProductId(productId);
        return new ResponseEntity<>(commentDtoList, HttpStatus.OK);
    }

    @GetMapping(path="/{productId}/{from}/{to}")
    public ResponseEntity<List<ProductCommentDto>> findByProductIdAndCommentDateBetween(
            @PathVariable("productId") Long productId,
            @PathVariable(value = "from",required = true) String fromStr,
            @PathVariable(value = "to",required = true) String toStr){

        List<ProductCommentDto> comments = commentService.getCommentsByProductIdAndBetweenTwoDates(productId, fromStr, toStr);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @GetMapping(path="/{userId}/{from}/{to}")
    public ResponseEntity<List<ProductCommentDto>> findByUserIdAndCommentDateBetween(
            @PathVariable("userId") Long userId,
            @PathVariable(value = "from",required = true) String fromStr,
            @PathVariable(value = "to",required = true) String toStr){

        List<ProductCommentDto> comments = commentService.getCommentsByUserIdAndBetweenTwoDates(userId, fromStr, toStr);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @GetMapping(path="/{userId}")
    public ResponseEntity<List<ProductCommentDto>> findAllUserComments(@PathVariable("userId") Long userId){
        List<ProductCommentDto> commentDtoList = commentService.getCommentsByUserId(userId);
        return new ResponseEntity<>(commentDtoList, HttpStatus.OK);
    }

}
