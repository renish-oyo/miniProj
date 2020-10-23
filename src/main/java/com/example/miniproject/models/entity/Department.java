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
@Table(name="department")
public class Department implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dept_id")
    private int dept_id;

    @Column(name = "dept_name")
    private String dept_name;

    @Column(name = "comp_id")
    private String comp_id;

    @Column(name = "manager_id")
    private String manager_id;

    @Column(name = "location")
    private String location;

    @Column(name = "phone")
    private String phone;

    @Column(name = "active")
    private int active;

    @Column(name = "created_at")
    private String created_at;

    @Column(name = "created_by")
    private String created_by;
}
