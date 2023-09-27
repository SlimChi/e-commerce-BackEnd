package fr.cs.bazarshop.service;

import fr.cs.bazarshop.dto.ProductDto;

import java.util.List;
import java.util.Optional;

public interface ProductService {


    ProductDto createProduct(ProductDto productDto);
    List<ProductDto> findAllProducts();
    Optional<ProductDto> findProductById(Integer id); // Nouvelle méthode pour rechercher un produit par ID
    void deleteProduct(Integer id); // Nouvelle méthode pour supprimer un produit par ID
    ProductDto updateProduct(Integer id, ProductDto productDto);


}
