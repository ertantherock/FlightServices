package com.example.amadeuscasestudy.entities;
import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    private String email;

    private String password;

    private boolean status;

    @ManyToMany
    private List<Role> roles;




}
