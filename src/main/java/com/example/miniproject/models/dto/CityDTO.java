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
public class CityDTO {
    @JsonProperty(value = "city_id")
    private int cityId;

    @JsonProperty(value = "city_name")
    private String cityName;

    @JsonProperty(value = "state_id")
    private int stateId;
}
