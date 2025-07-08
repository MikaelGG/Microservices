package com.microservice_webs.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "web_pages")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WebPages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 125)
    private String name;

    @Column(name = "description", nullable = false, length = 255, columnDefinition = "TEXT")
    private String description;

    @Column(name = "price", nullable = false, length = 55)
    private Double price;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public WebPages(Long id) {
        this.id = id;
    }

}
