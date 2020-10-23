package com.example.miniproject.models.entity;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="salary")
public class Salary implements Serializable {
    @Id
    @Column(name = "sn")
    private int sn;

    @Column(name = "emp_id")
    private String emp_id;

    @Column(name = "salary_amount")
    private int salary_amount;

    @Column(name = "active")
    private int active;

    @Column(name = "created_at")
    private String created_at;

    @Column(name = "created_by")
    private String created_by;
}
