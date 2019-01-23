package com.example.demo.service.impl;

import com.example.demo.domain.UserDTO;
import com.example.demo.entity.UserEntity;

import java.util.List;

public interface UserService {

    void  saveUser(UserDTO user);
    List<UserDTO> findAllUsers();

    UserDTO findUserById(int id);
    UserDTO updateUser(int id, UserDTO userToUpdate);

}
