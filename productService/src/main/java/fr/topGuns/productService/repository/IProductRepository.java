package fr.topGuns.productService.repository;

import fr.topGuns.productService.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<ProductEntity,Long> {
    ProductEntity findByProductName(String productName);

}