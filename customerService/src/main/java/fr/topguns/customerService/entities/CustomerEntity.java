package fr.topguns.customerService.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;
@Data
@Builder
@Entity
@Table(name = "UserTable",uniqueConstraints = { @UniqueConstraint(columnNames = { "username", "email" }) })
public class CustomerEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50,nullable = false)
    private String username;
    @Column(length = 80,nullable = false)
    private String email;
    @Column(length = 14,nullable = false)
    private String password;
    @Column
    private LocalDateTime createDate;
    @Column
    private LocalDateTime editDate;
    @Column(nullable = false)
    private int isAdmin;
    @Column(nullable = false)
    private int isActive;
}
