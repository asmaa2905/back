package fr.topGuns.productService.service;

import fr.topGuns.productService.entity.ProductEntity;
import fr.topGuns.productService.repository.IProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductServiceImpl implements IProductService{
    @Autowired
    private IProductRepository productRepository;


    @Override
    public List<ProductEntity> getAllProducts() {

        return productRepository.findAll();
    }

    @Override
    public ProductEntity getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("L'entité n'a pas été trouvée pour l'ID : " + id));
    }

    @Override
    public ProductEntity getProductByProductName(String username) {
        return productRepository.findByProductName(username);
    }

    @Override
    public ProductEntity createProduct(ProductEntity product){
        return productRepository.save(product);
    }

    @Override
    public ProductEntity updateProduct(ProductEntity product) {
        return productRepository.save(product);
    }

    @Override
    public Boolean deleteProduct(Long productId) {
        //Todo : Tomorrow morning
        try{
            ProductEntity product = productRepository.findById(productId).orElseThrow();
            product.setQuantity(0);
            productRepository.save(product);
            return true;
        }catch(NoSuchElementException e){
            return false;
        }
    }
}
