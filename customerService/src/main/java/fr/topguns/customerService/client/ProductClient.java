package fr.topguns.customerService.client;


import fr.topguns.customerService.entities.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="product-service", url = "${application.config.product.url}")
public interface ProductClient {

    @GetMapping("/user/{idUser}")
    List<Product> findAllProductsByUser(@PathVariable("idUser") Long idUser);
}
