package fr.topguns.customerService.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerResponse {
    private String username;
    private String email;
    private String password;
    private LocalDateTime createDate;
    private LocalDateTime editDate;
    private int isAdmin;
    private int isActive;
    List<Product> products;
}
