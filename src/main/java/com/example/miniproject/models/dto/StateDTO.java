package com.example.miniproject.models.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StateDTO {
    @JsonProperty(value = "state_id")
    private int stateId;

    @JsonProperty(value = "state_name")
    private String stateName;

    @JsonProperty(value = "country_id")
    private int countryId;
}
