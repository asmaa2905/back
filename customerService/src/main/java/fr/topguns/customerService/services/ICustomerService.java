package fr.topguns.customerService.services;

import fr.topguns.customerService.entities.CustomerEntity;
import fr.topguns.customerService.entities.CustomerResponse;

import java.util.List;

public interface ICustomerService {
    public List<CustomerEntity> getAllUsers();
    public CustomerEntity getUserById(Long id);
    public CustomerEntity getUserByUsername(String username);
    public CustomerEntity getUserByEmail(String email);
    public CustomerResponse findCustomersWithProduct(Long id);
    public CustomerEntity createUser(CustomerEntity user);
    public CustomerEntity updateUser(CustomerEntity user);
    public Boolean deleteUser(Long id);
}
