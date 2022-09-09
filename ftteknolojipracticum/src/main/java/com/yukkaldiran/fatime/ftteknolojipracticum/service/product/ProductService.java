package com.yukkaldiran.fatime.ftteknolojipracticum.service.product;

import com.yukkaldiran.fatime.ftteknolojipracticum.dto.converter.ProductConverter;
import com.yukkaldiran.fatime.ftteknolojipracticum.dto.mapper.ProductMapper;
import com.yukkaldiran.fatime.ftteknolojipracticum.dto.product.ProductDto;
import com.yukkaldiran.fatime.ftteknolojipracticum.dto.product.ProductSaveRequestDto;
import com.yukkaldiran.fatime.ftteknolojipracticum.dto.product.ProductUpdateRequestDto;
import com.yukkaldiran.fatime.ftteknolojipracticum.entity.product.Product;
import com.yukkaldiran.fatime.ftteknolojipracticum.exception.ProductNotFoundException;
import com.yukkaldiran.fatime.ftteknolojipracticum.repository.product.ProductRepository;
import com.yukkaldiran.fatime.ftteknolojipracticum.utils.ErrorMessageConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService{

    private final ProductRepository productRepository;
    private final ProductMapper mapper;
    private final ProductConverter converter;

    public ProductDto createProduct(ProductSaveRequestDto productRequest){
        Product product = mapper.convertToProduct(productRequest);
        return mapper.convertToProductDto(productRepository.save(product));
    }

    public List<ProductDto> getAllProducts(){
        return converter.convertToProductDtoList(productRepository.findAll());
    }

    public ProductDto updateProduct(Long productId, ProductUpdateRequestDto updateProductRequest){
        Product product = findProductById(productId);

        Product updatedProduct = new Product(
                product.getId(),
                updateProductRequest.getName(),
                updateProductRequest.getPrice(),
                updateProductRequest.getExpirationDate(),
                product.getProductComments()
        );
        return mapper.convertToProductDto(productRepository.save(updatedProduct));
    }

    public ProductDto getProductById(Long productId){
        return mapper.convertToProductDto(findProductById(productId));
    }

    public String deleteProduct(Long productId){
        productRepository.delete(findProductById(productId));
        return productId + " deleted ...";
    }

    public List<ProductDto> getExpiredProducts(){
        List<Product> products = productRepository.findByExpirationDateBefore(LocalDate.now());
        return converter.convertToProductDtoList(products);
    }

    public List<ProductDto> getNullOrNonExpiredProducts(){
        List<Product> products = productRepository.findByExpirationDateOrExpirationDateAfter(null,LocalDate.now());
        return converter.convertToProductDtoList(products);
    }

    public Product findProductById(Long productId){
        return productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException(ErrorMessageConstants.PRODUCT_NOT_FOUND));
    }
}
