package com.example.miniproject.models.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_roles")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRoles implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private int roleId;

    @Column(name = "role_name")
    private String roleName;
}