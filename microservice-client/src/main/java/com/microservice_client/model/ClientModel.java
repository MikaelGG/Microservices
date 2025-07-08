package com.microservice_client.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "client")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientModel {

    @Id
    @Column(name = "id_document", unique = true, nullable = false, length = 125, updatable = true)
    private Long documentId;
    @Column(name = "name", nullable = false, length = 55)
    private String name;
    @Column(name = "lastname", nullable = false, length = 55)
    private String lastname;
    @Column(name = "phone", nullable = false, length = 45)
    private Long phone;
    @Column(name = "age", nullable = false, length = 10)
    private Integer age;
    @Column(name = "email", nullable = false, length = 125)
    private String email;

}
