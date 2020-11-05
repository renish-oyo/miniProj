package com.example.miniproject.models.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CompanyDTO {
    @JsonProperty(value= "comp_id")
    private int companyId;

    @JsonProperty(value = "comp_name")
    private String companyName;

    @JsonProperty(value = "location")
    private String location;

    @JsonProperty(value ="domain" )
    private String domain;

    @JsonProperty(value = "phone")
    private String phone;

    @JsonProperty(value = "revenue")
    private String revenue;

    @JsonProperty(value = "active")
    private boolean active=true;

    @CreationTimestamp
    @JsonProperty(value = "create_date")
    private LocalDateTime createDateTime;

    @UpdateTimestamp
    @JsonProperty(value = "update_date")
    private LocalDateTime updateDateTime;
}
