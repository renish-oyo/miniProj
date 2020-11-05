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
@Table(name="employee")
public class Employee implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private int employeeId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "gender")
    private String gender;

    @Column(name = "email",unique = true)
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="phone")
    private String phone;

    @Column(name = "aadhar_number")
    private String aadharNumber;

    @Column(name="pan_number")
    private String panNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "bank_name")
    private String bankName;

    @Column(name = "bank_account_number")
    private String bankAccountNumber;

    @Column(name = "bank_ifsc_code")
    private String banKIfscCode;

    @Column(name = "designation")
    @Enumerated(EnumType.STRING)
    private Designation designation;

    @Column(name = "active")
    private boolean active=true;

    @CreationTimestamp
    @Column(name = "create_date")
    private LocalDateTime createDateTime;

    @UpdateTimestamp
    @Column(name = "update_date")
    private LocalDateTime updateDateTime;

    @Lob
    @Column(name = "image")
    private byte[] image;

    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
    @JoinColumn(name = "dept_id")
    private Department department;

    @OneToOne
    @JoinColumn(name = "salary_id")
    private Salary salary;
}
