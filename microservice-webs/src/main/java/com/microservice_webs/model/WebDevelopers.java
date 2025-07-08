package com.microservice_webs.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "web_developers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WebDevelopers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_web", nullable = false)
    private WebPages idWeb;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_developer", nullable = false)
    private Developers idDeveloper;

}
