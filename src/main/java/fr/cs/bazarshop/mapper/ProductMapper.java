package fr.cs.bazarshop.mapper;

import fr.cs.bazarshop.dto.ProductDto;
import fr.cs.bazarshop.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;


@Mapper

public interface ProductMapper {
    ProductDto toProductDto(Product product);

    Product toProduct(ProductDto productDto);
}

