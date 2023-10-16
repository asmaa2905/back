package fr.topGuns.productService.mapper;

import fr.topGuns.productService.dto.ProductDto;
import fr.topGuns.productService.entity.ProductEntity;
import org.modelmapper.ModelMapper;
public class ProductMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    public ProductDto toDto(ProductEntity productEntity) {
        return modelMapper.map(productEntity, ProductDto.class);
    }

    public ProductEntity fromDto(ProductDto productDto) {
        return modelMapper.map(productDto, ProductEntity.class);
    }
}
