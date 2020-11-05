package com.example.miniproject.models.entity;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="salary")
public class Salary implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "salary_id")
    private int salaryId;

    @Column(name = "salary_amount")
    private String salaryAmount;

    @Column(name = "active")
    private boolean active=true;

    @CreationTimestamp
    @Column(name = "create_date")
    private LocalDateTime createDateTime;

    @UpdateTimestamp
    @Column(name = "update_date")
    private LocalDateTime updateDateTime;

}