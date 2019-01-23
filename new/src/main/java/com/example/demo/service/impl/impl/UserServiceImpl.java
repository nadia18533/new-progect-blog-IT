package com.example.demo.service.impl.impl;

import com.example.demo.domain.UserDTO;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;


    @Override
    public void saveUser(UserDTO user) {

        UserEntity userEntity=new UserEntity();

        userRepository.save(dtoToEntityMapper(user));
    }

    @Override
    public List<UserDTO> findAllUsers() {
        List<UserEntity>users=userRepository.findAll();
        List<UserDTO>userDTOS=new ArrayList<>();

        for (UserEntity entity:users){
            UserDTO userDTO= entityToDTOMapper(entity);
            userDTOS.add(userDTO);
        }
        return userDTOS;
    }
    @Override
    public UserDTO findUserById(int id) {
        boolean exists=userRepository.existsById(id);
        if(!exists){

            return  null;
        }
        UserEntity users=userRepository.findById(id).get();

        return entityToDTOMapper(users);
    }

    @Override
    public UserDTO updateUser(int id, UserDTO userToUpdate) {
        boolean exists=userRepository.existsById(id);
        if(!exists){

            return  null;
        }UserEntity userFromDB=userRepository.findById(id).get();
        userFromDB=dtoToEntityMapper(userToUpdate);
        userRepository.save(userFromDB);
        userToUpdate.setId(userFromDB.getId());

        return userToUpdate;
    }
    private UserDTO entityToDTOMapper(UserEntity userEntity){
        UserDTO userDTO= new UserDTO();
        userDTO.setDateOfCreate(userEntity.getDateOfCreate());
        userDTO.setName(userEntity.getName());
        userDTO.setSecondName(userEntity.getSecondName());
        userDTO.setId(userEntity.getId());
        userDTO.setNickname(userEntity.getNickname());

        return  userDTO;
    }
    private  UserEntity dtoToEntityMapper(UserDTO userDTO){
        UserEntity userEntity=new UserEntity();
        userEntity.setName(userDTO.getName());
        userEntity.setNickname(userDTO.getNickname());
        userEntity.setDateOfCreate(userDTO.getDateOfCreate());
        userEntity.setId(userDTO.getId());
        userEntity.setSecondName(userDTO.getSecondName());

        return  userEntity;
    }
}
