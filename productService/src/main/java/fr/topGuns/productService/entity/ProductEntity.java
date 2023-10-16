package fr.topGuns.productService.entity;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "product")
public class ProductEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(length = 50,nullable = false)
        private String productName;
        @Column(nullable = false)
        private int quantity;
        @Column(nullable = false)
        private Long price;
        @Column(nullable = false)
        private String picture;

}
