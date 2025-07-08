package com.microservice_webs.model;

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
public class Invoices {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "issue_date", nullable = false)
    private LocalDateTime issueDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_web_page", nullable = false)
    @JsonIgnoreProperties({"description", "price"})
    private WebPages idWebPage;

    @Column(name = "id_client", nullable = false)
    private Long idClient;

}
