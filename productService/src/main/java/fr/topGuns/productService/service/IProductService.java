package fr.topGuns.productService.service;

import fr.topGuns.productService.entity.ProductEntity;

import java.util.List;

public interface IProductService {
    public List<ProductEntity> getAllProducts();
    public ProductEntity getProductById(Long id);
    public ProductEntity getProductByProductName(String username);
    public List<ProductEntity> findAllProductsByUser(Long idUser);
    public ProductEntity createProduct(ProductEntity product);
    public ProductEntity updateProduct(ProductEntity user);
    public Boolean deleteProduct(Long userId);
}
