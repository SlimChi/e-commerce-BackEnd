package fr.cs.bazarshop.dto;

import fr.cs.bazarshop.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private Integer id;

    private String productName;

    private String description;

    private boolean stock;

    private int productQuantity;

    private String productImage;

    private Double price;

    private CategoryDto categoryDto;


}
