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
public class CountryDTO {
    @JsonProperty(value = "country_id")
    private int countryId;

    @JsonProperty(value = "country_name")
    private String countryName;
}
