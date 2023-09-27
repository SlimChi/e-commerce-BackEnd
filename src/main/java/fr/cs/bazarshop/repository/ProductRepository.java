package fr.cs.bazarshop.repository;

import fr.cs.bazarshop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
