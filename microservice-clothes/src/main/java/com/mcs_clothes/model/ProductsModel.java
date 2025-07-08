package com.mcs_clothes.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "quantity", nullable = false)
    private Long quantity;

    @Column(name = "price", nullable = false)
    private Double price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", nullable = false)
    private CategoriesModel category;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public ProductsModel(Long id) {
        this.id = id;
    }

}
