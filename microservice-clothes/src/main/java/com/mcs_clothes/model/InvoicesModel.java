package com.mcs_clothes.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "invoices")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoicesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_client", nullable = false)
    private Long idClient;

    @Column(name = "issue_date", nullable = false)
    private LocalDateTime issueDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_product", nullable = false)
    @JsonIgnoreProperties({"id", "description", "quantity", "price", "category"})
    private ProductsModel product;

    @Column(name = "total", nullable = false)
    private Double total;

}
