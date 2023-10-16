package fr.topguns.customerService.dto;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class CustomerDto {
        private Long id;
        private String username;
        private String email;
        private String password;
        private LocalDateTime createDate;
        private LocalDateTime editDate;
        private int isAdmin;
        private int isActive;
}
