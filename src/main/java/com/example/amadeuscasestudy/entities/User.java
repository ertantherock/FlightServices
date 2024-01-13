package com.example.amadeuscasestudy.entities;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    @NotNull
    @Email(message = "Text needs to be in Email format")
    private String email;

    @NotNull
    private String password;

    private boolean status;

    @ManyToMany
    private List<Role> roles;




}
