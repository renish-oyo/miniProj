package com.example.miniproject.models.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CompanyDTO implements Serializable {

    private static final long serialVersionUID = 4L;

    @JsonProperty(value= "comp_id")
    private int companyId;

    @JsonProperty(value = "comp_name")
    private String companyName;

    @JsonProperty(value = "street")
    private String street;

    @JsonProperty(value = "city")
    private String city;

    @JsonProperty(value="state")
    private String state;

    @JsonProperty(value = "country")
    private String country;

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
