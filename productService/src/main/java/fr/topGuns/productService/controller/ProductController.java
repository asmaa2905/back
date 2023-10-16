package fr.topGuns.productService.controller;

import fr.topGuns.productService.dto.ProductDto;
import fr.topGuns.productService.entity.ProductEntity;
import fr.topGuns.productService.mapper.ProductMapper;
import fr.topGuns.productService.service.IProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
@Slf4j
public class ProductController {
    @Autowired
    private IProductService productService;
    ProductMapper productMapper = new ProductMapper();

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductDto> getUsers() {
        return  productService.getAllProducts().stream()
                .filter(product -> (product.getQuantity()>0))
                .sorted(Comparator.comparingLong(ProductEntity::getId))
                .map(productMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/byId")
    @ResponseStatus(HttpStatus.OK)
    public ProductDto productById(@RequestParam(name = "id") Long id){
        return productMapper.toDto(productService.getProductById(id));
    }

    @GetMapping("/byProductName")
    @ResponseStatus(HttpStatus.OK)
    public ProductDto userByUsername(@RequestParam(name = "productName") String productName){
        return productMapper.toDto(productService.getProductByProductName(productName));
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDto createProduct(@RequestBody ProductDto product){
        ProductEntity productCreated= productService.createProduct(productMapper.fromDto(product));
        return productMapper.toDto(productCreated);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public ProductDto updateProduct(@RequestBody ProductDto product){
        ProductEntity productEntity = productMapper.fromDto(product);
        return productMapper.toDto(productService.updateProduct(productEntity));
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.OK)
    public String deleteProduct(@RequestParam(name = "id") Long id){
        return productService.deleteProduct(id)? "Product successfully deleted":"Error in deletion";
    }
}
