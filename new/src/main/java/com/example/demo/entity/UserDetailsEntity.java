package com.example.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "details")
public class UserDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String email;
    @Column(name = "date_of_birth", nullable = false, columnDefinition = "DATE")
    private String dateOfBirth;
    @Column(name = "marital_status", nullable = false)
    private String maritalStatus;
    @Column(nullable = false)
    private String hobby;
    @Column(name = "list_of_technologies", nullable = false)
    private String listOfTechnologies;

    @OneToOne
    @JoinColumn(name = "user_id")
    private  UserEntity user;

}