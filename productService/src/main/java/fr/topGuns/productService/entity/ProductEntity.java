package fr.topGuns.productService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
        @Column
        private int idUser;

}
