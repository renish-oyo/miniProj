package com.example.miniproject.models.entity;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.*;

import java.io.Serializable;
@Getter
public enum Designation implements Serializable {
    SDE("sde"),
    FOUNDER("founder");

    private String designation;
    Designation(String designation){
        this.designation=designation;
    }

    @JsonValue
    public String getDesignation() {
        return designation;
    }
}
