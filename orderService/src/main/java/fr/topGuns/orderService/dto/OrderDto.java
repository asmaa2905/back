package fr.topGuns.orderService.dto;


import fr.topGuns.orderService.entities.OrderDetailEntity;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class OrderDto {
    private Long idOrder;
    private Long idUser;
    private LocalDateTime createDate;
    private boolean status;
    List<OrderDetailDto> orderDetails = new ArrayList<>();
}
