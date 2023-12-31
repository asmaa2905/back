package fr.topGuns.orderService.repositories;

import fr.topGuns.orderService.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrderRepository extends JpaRepository<OrderEntity,Long> {
    List<OrderEntity> findByIdUser(Long idUser);
}
