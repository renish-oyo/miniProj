package com.example.miniproject.Entity;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

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
    private String created_at;

    @Column(name = "created_by")
    private String created_by;

}
