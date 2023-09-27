package fr.cs.bazarshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String productName;

    private String description;

    private Boolean stock = true;

    private Integer productQuantity;

    private String productImage;

    private Double price;


    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}

