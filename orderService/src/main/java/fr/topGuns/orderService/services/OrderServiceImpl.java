package fr.topGuns.orderService.services;

import fr.topGuns.orderService.entities.OrderEntity;
import fr.topGuns.orderService.repositories.IOrderRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class OrderServiceImpl implements IOrderService{
    @Autowired
    private IOrderRepository orderRepository;

    @Override
    public List<OrderEntity> getAllOrders() {
        List<OrderEntity> list = orderRepository.findAll();
        return list ;
    }

    @Override
    public OrderEntity getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("L'entité n'a pas été trouvée pour l'ID : " + id));
    }
    @Override
    public List<OrderEntity>  getOrdersByIdUser(Long idUser) {

        return orderRepository.findByIdUser(idUser);
    }

    @Override
    public OrderEntity createOrder(OrderEntity order){

        return orderRepository.save(order);
    }

    @Override
    public OrderEntity updateOrder(OrderEntity order) {
        LocalDateTime date = LocalDateTime.now();
        order.setCreateDate(date);
        return orderRepository.save(order);
    }

    @Override
    public Boolean deleteOrder(Long orderId) {
        //Todo : Tomorrow morning
        try{
            LocalDateTime date = LocalDateTime.now();
            OrderEntity order = orderRepository.findById(orderId).orElseThrow();
            order.setStatus(true);
            orderRepository.save(order);
            return true;
        }catch(NoSuchElementException e){
            return false;
        }
    }
}
