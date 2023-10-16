package fr.topguns.customerService.repositories;

import fr.topguns.customerService.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<CustomerEntity,Long> {
    CustomerEntity findByUsername(String username);
    CustomerEntity findByEmail(String email);
}
