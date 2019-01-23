package com.example.demo.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
    private int id;
    private String name;
    private String secondName;
    private String nickname;
    private String dateOfCreate;

}
