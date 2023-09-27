package fr.cs.bazarshop.controller;


import fr.cs.bazarshop.dto.ProductDto;
import fr.cs.bazarshop.entity.Product;
import fr.cs.bazarshop.exeption.CustomError;
import fr.cs.bazarshop.exeption.ProductNotFoundException;
import fr.cs.bazarshop.exeption.ResponseWrapper;
import fr.cs.bazarshop.service.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
@Tag(name = "products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @PostMapping("/save")
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto) {
        ProductDto savedProduct = productService.createProduct(productDto);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    @GetMapping("/findAllProduct")
    public ResponseEntity<List<ProductDto>> findAllProducts() {
        List<ProductDto> products = productService.findAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<ResponseWrapper<?>> findProductById(@PathVariable Integer id) {
        Optional<ProductDto> product = productService.findProductById(id);

        if (product.isPresent()) {
            return ResponseEntity.ok(new ResponseWrapper<>(product.get()));
        } else {
            String errorMessage = "Le produit avec l'ID " + id + " n'existe pas.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ResponseWrapper<>(new CustomError(errorMessage)));
        }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseWrapper<Void>> deleteProduct(@PathVariable Integer id) {
        try {
            productService.deleteProduct(id);
            return new ResponseEntity<>(new ResponseWrapper<>(null), HttpStatus.NO_CONTENT);
        } catch (ProductNotFoundException ex) {
            String errorMessage = "Le produit avec l'ID " + id + " n'existe pas.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ResponseWrapper<>(new CustomError(errorMessage)));
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseWrapper<ProductDto>> updateProduct(@PathVariable Integer id, @RequestBody ProductDto productDto) {
        try {
            ProductDto updatedProduct = productService.updateProduct(id, productDto);
            return new ResponseEntity<>(new ResponseWrapper<>(updatedProduct), HttpStatus.OK);
        } catch (ProductNotFoundException ex) {
            String errorMessage = "Le produit avec l'ID " + id + " n'existe pas.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ResponseWrapper<>(new CustomError(errorMessage)));
        }
    }




}
