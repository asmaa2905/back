package fr.topguns.customerService.services;

import fr.topguns.customerService.entities.CustomerEntity;

import java.util.List;

public interface ICustomerService {
    public List<CustomerEntity> getAllUsers();
    public CustomerEntity getUserById(Long id);
    public CustomerEntity getUserByUsername(String username);
    public CustomerEntity getUserByEmail(String email);
    public CustomerEntity createUser(CustomerEntity user);
    public CustomerEntity updateUser(CustomerEntity user);
    public Boolean deleteUser(Long userId);
}
