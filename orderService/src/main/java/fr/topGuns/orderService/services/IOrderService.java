package fr.topGuns.orderService.services;

import fr.topGuns.orderService.entities.OrderDetailEntity;
import fr.topGuns.orderService.entities.OrderEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IOrderService {
    public List<OrderEntity> getAllOrders();
    public OrderEntity getOrderById(Long id);
    public List<OrderEntity> getOrdersByIdUser(Long idUser);
    public OrderEntity createOrder(OrderEntity order);
    public OrderEntity updateOrder(OrderEntity order);
    public Boolean deleteOrder(Long orderId);
}
