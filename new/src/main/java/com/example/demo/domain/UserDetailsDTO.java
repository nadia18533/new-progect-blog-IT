package com.example.demo.domain;

import com.example.demo.entity.UserEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Getter
@Setter
@NoArgsConstructor
public class UserDetailsDTO {
    private int id;
    private String email;
    private String dateOfBirth;
    private String maritalStatus;
    private String hobby;
    private String listOfTechnologies;
    private UserEntity user;
}
