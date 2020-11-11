package com.example.miniproject.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name="department")
public class Department implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dept_id")
    private int departmentId;

    @Column(name = "dept_name")
    private String departmentName;

    @Column(name = "location")
    private String location;

    @Column(name = "phone")
    private String phone;

    @Column(name = "active")
    private boolean active;

    @CreationTimestamp
    @Column(name = "create_date")
    private LocalDateTime createDateTime;

    @UpdateTimestamp
    @Column(name = "update_date")
    private LocalDateTime updateDateTime;

    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
    @JoinColumn(name = "comp_id")
    @JsonIgnore // To Solve "Jackson infinite recursion problem" during pagination
    private Company company;

    @OneToMany(mappedBy = "department",fetch = FetchType.EAGER)
    private List<Employee> employeeList;

    @OneToMany(mappedBy = "department",fetch =FetchType.LAZY)
    private List<Salary> salaryList;
}
