package com.microservice_webs.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "developers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Developers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false, length = 55)
    private String name;
    @Column(name = "last_name", nullable = false, length = 55)
    private String lastName;
    @Column(name = "age", nullable = false, length = 10)
    private Integer age;
    @Column(name = "short_description", nullable = false, length = 255)
    private String shortDescription;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public Developers(Long id) {
        this.id = id;
    }

}
