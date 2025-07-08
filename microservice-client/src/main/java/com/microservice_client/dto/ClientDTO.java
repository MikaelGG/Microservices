package com.microservice_client.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {

    private Long documentId;
    private String name;
    private String lastname;
    private Long phone;
    private Integer age;
    private String email;

}
