package com.yukkaldiran.fatime.ftteknolojipracticum.controller.product;

import com.yukkaldiran.fatime.ftteknolojipracticum.dto.product.ProductDto;
import com.yukkaldiran.fatime.ftteknolojipracticum.dto.product.ProductSaveRequestDto;
import com.yukkaldiran.fatime.ftteknolojipracticum.dto.product.ProductUpdateRequestDto;
import com.yukkaldiran.fatime.ftteknolojipracticum.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/product")
@RequiredArgsConstructor

public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductDto> saveProduct(@Valid @RequestBody ProductSaveRequestDto productSaveRequestDto){
        ProductDto productDto = productService.createProduct(productSaveRequestDto);
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<ProductDto>> findAll(){
        List<ProductDto> productDtos = productService.getAllProducts();
        return new ResponseEntity<>(productDtos, HttpStatus.OK);
    }

   @PutMapping(path = "/{productId}")
   public ResponseEntity<ProductDto> updateProduct(@PathVariable Long productId, @Valid @RequestBody ProductUpdateRequestDto updateProductRequest){
       ProductDto productDto = productService.updateProduct(productId, updateProductRequest);
       return new ResponseEntity<>(productDto, HttpStatus.OK);
   }

    @GetMapping(path="/{productId}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable("productId") Long productId){
        ProductDto productDto = productService.getProductById(productId);
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }

    @DeleteMapping(path="/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable("productId") Long productId){
       String result = productService.deleteProduct(productId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(path = "/expired")
    public ResponseEntity<List<ProductDto>> getExpiredProducts(){
        List<ProductDto> products = productService.getExpiredProducts();

        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping(path = "/notExpired")
    public ResponseEntity<List<ProductDto>> getNullOrNonExpiredProducts(){

        List<ProductDto> products = productService.getNullOrNonExpiredProducts();

        return new ResponseEntity<>(products, HttpStatus.OK);

    }
}
