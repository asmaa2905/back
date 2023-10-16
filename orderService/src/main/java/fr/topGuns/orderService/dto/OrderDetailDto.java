package fr.topGuns.orderService.dto;


import fr.topGuns.orderService.entities.OrderEntity;
import lombok.Data;

@Data
public class OrderDetailDto {
    private Long id;
    private Long idProduct;
    private double price;
    private Long quantity;
    private OrderEntity order;
}
