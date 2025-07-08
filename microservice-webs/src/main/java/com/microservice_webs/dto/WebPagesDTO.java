package com.microservice_webs.dto;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WebPagesDTO {

    private String name;
    private String description;
    private Double price;
    private List<Devs> devsList;

    @Data
    @NoArgsConstructor
    public static class Devs {
        private Long id;

        @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
        public Devs(Long id) {
            this.id = id;
        }
    }

}
