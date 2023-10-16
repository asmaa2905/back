package fr.topGuns.orderService.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrder;
    @Column(nullable = false)
    private Long idUser;
    @Column(nullable = false)
    private LocalDateTime createDate;
    @Column(nullable = false)
    private boolean status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    List<OrderDetailEntity> orderDetails = new ArrayList<>();
}
