package com.mcs_clothes.dto;

import com.mcs_clothes.model.ProductsModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoicesDTO {

    private LocalDateTime issueDate;
    private ProductsModel product;
    private ClientDTO idClient;
    private Double total;

}
