package com.microservice_webs.dto;

import com.microservice_webs.model.WebPages;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoicesDTO {

    private LocalDateTime issueDate;
    private WebPages idWebPage;
    private ClientDTO idClient;

}
