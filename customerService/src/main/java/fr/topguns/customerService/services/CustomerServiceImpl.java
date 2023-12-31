package fr.topguns.customerService.services;

import fr.topguns.customerService.client.ProductClient;
import fr.topguns.customerService.entities.CustomerEntity;
import fr.topguns.customerService.entities.CustomerResponse;
import fr.topguns.customerService.repositories.ICustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService{
    @Autowired
    private ICustomerRepository userRepository;
    @Autowired
    private ProductClient productClient;
    @Override
    public List<CustomerEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public CustomerEntity getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("L'entité n'a pas été trouvée pour l'ID : " + id));
    }

    @Override
    public CustomerEntity getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public CustomerEntity getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public CustomerResponse findCustomersWithProduct(Long id){
        var customer = userRepository.findById(id).orElse(CustomerEntity.builder()
                        .username("not found")
                        .email("not found")
                        .password("not found")
                        .createDate(LocalDateTime.now())
                        .editDate(LocalDateTime.now())
                        .isAdmin(0)
                        .isActive(0)
                        .build());
        var product = productClient.findAllProductsByUser(id);
        return CustomerResponse.builder()
                .username(customer.getUsername())
                .email(customer.getEmail())
                .password(customer.getPassword())
                .createDate(customer.getCreateDate())
                .editDate(customer.getEditDate())
                .isAdmin(customer.getIsAdmin())
                .isActive(customer.getIsActive())
                .products(product)
                .build();
    }
    @Override
    public CustomerEntity createUser(CustomerEntity user){
        return userRepository.save(user);
    }

    @Override
    public CustomerEntity updateUser(CustomerEntity user) {
        return userRepository.save(user);
    }

    @Override
    public Boolean deleteUser(Long userId) {
        //Todo : Tomorrow morning
        try{
            LocalDateTime date = LocalDateTime.now();
            CustomerEntity user = userRepository.findById(userId).orElseThrow();
                user.setIsActive(0);
                user.setUsername(user.getUsername() + "_deleted_" + date);
                user.setEmail(user.getEmail() + "_deleted_" + date);
                userRepository.save(user);
            return true;
        }catch(NoSuchElementException e){
            return false;
        }
    }
}
