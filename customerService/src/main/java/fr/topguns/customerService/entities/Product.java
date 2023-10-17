package fr.topguns.customerService.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
        private String productName;
        private int quantity;
        private Long price;
        private String picture;

}
