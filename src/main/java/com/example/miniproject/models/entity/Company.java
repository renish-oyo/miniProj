package com.example.miniproject.models.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="company")
public class Company implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comp_id")
    private int companyId;

    @Column(name = "comp_name")
    private String companyName;

    @Column(name = "location")
    private String location;

    @Column(name ="domain" )
    private String domain;

    @Column(name = "phone")
    private String phone;

    @Column(name = "revenue")
    private String revenue;

    @Column(name = "active")
    private boolean active;

    @CreationTimestamp
    @Column(name = "create_date")
    private LocalDateTime createDateTime;

    @UpdateTimestamp
    @Column(name = "update_date")
    private LocalDateTime updateDateTime;

    @OneToMany(mappedBy = "company",fetch = FetchType.LAZY)
    private List<Department> departmentList;
}
