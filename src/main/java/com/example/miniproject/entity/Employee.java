package com.example.miniproject.entity;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="employee")
public class Employee implements Serializable{

    private enum Desig{
        SDE,
        CEO,
        SDE_2,
        Founder
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private int emp_id;

    @Column(name = "emp_name")
    private String emp_name;

    @Column(name = "dept_id")
    private int dept_id;

    @Column(name = "address")
    private String address;


    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "designation")
    private Desig designation;

    @Column(name = "active")
    private int active;

    @Column(name = "created_at")
    private String created_at;

    @Column(name = "created_by")
    private String created_by;
}
