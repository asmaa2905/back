package fr.topguns.customerService.mapper;

import fr.topguns.customerService.dto.CustomerDto;
import fr.topguns.customerService.entities.CustomerEntity;
import org.modelmapper.ModelMapper;

public class CustomerMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    public CustomerDto toDto(CustomerEntity customerEntity) {
        return modelMapper.map(customerEntity, CustomerDto.class);
    }

    public CustomerEntity fromDto(CustomerDto customerDto) {
        return modelMapper.map(customerDto, CustomerEntity.class);
    }
}
