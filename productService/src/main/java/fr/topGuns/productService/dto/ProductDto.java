package fr.topGuns.productService.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDto {
    private Long id;
    private String productName;
    private int quantity;
    private Long price;
    private String picture;
    private int idUser;
}
