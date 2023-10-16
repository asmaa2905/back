package fr.topGuns.orderService.mapper;

import fr.topGuns.orderService.dto.OrderDetailDto;
import fr.topGuns.orderService.dto.OrderDto;
import fr.topGuns.orderService.entities.OrderDetailEntity;
import fr.topGuns.orderService.entities.OrderEntity;
import org.modelmapper.ModelMapper;
public class OrderMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    public OrderDto toDto(OrderEntity orderEntity) {

        return modelMapper.map(orderEntity, OrderDto.class);
    }

    public OrderEntity fromDto(OrderDto orderDto) {

        return modelMapper.map(orderDto, OrderEntity.class);
    }

}
