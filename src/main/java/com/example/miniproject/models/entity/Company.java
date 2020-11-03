package com.example.miniproject.models.entity;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
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
    @Column(name = "comp_id")
    private int comp_id;

    @Column(name = "comp_name")
    private String comp_name;

    @Column(name = "location")
    private String location;

    @Column(name ="domain" )
    private String domain;

    @Column(name = "phone")
    private String phone;

    @Column(name = "revenue")
    private String revenue;

    @Column(name = "active")
    private int active;

    @Column(name = "created_at")
    private Date created_at;

    @Column(name = "created_by")
    private String created_by;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "comp_dept_fk",referencedColumnName = "dept_id")
    List<Department> departmentList;

}
