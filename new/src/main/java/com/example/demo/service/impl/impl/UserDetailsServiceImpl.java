package com.example.demo.service.impl.impl;

import com.example.demo.domain.UserDetailsDTO;
import com.example.demo.entity.UserDetailsEntity;
import com.example.demo.repository.UserDetailsRepository;
import com.example.demo.service.impl.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl  implements UserDetailsService {
    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Override
    public void saveUserDetail(UserDetailsDTO userDetail) {

        userDetailsRepository.save(dtoToEntityMapper(userDetail));
    }

    @Override
    public List<UserDetailsDTO> findAllUserDetails() {
        List<UserDetailsEntity>userDetails=userDetailsRepository.findAll();
        List<UserDetailsDTO>userDetailsDTOS=new ArrayList<>();
        for (UserDetailsEntity entity:userDetails){
            UserDetailsDTO userDetailsDTO = entityToDTOMapper(entity);
            userDetailsDTOS.add(userDetailsDTO);
        }
        return userDetailsDTOS;
    }

    @Override
    public UserDetailsDTO findUserDetailById(int id) {
        boolean exists=userDetailsRepository.existsById(id);
        if(!exists){

            return  null;
        }
        UserDetailsEntity userDetails=userDetailsRepository.findById(id).get();

        return entityToDTOMapper(userDetails);
    }  @Override
    public UserDetailsDTO updateUserDetails(int id, UserDetailsDTO userDetailsToUpdate) {
        boolean exists=userDetailsRepository.existsById(id);
        if(!exists){

            return  null;
        }

        UserDetailsEntity userDetailsFromDB=userDetailsRepository.findById(id).get();
        userDetailsFromDB=dtoToEntityMapper(userDetailsToUpdate);
        userDetailsRepository.save(userDetailsFromDB);
        userDetailsToUpdate.setId(userDetailsFromDB.getId());

        return userDetailsToUpdate;
    }
    private  UserDetailsDTO entityToDTOMapper(UserDetailsEntity userDetailsEntity){
        UserDetailsDTO userDetailsDTO = new UserDetailsDTO();
        userDetailsDTO.setId(userDetailsEntity.getId());
        userDetailsDTO.setDateOfBirth(userDetailsEntity.getDateOfBirth());
        userDetailsDTO.setEmail(userDetailsEntity.getEmail());
        userDetailsDTO.setHobby(userDetailsEntity.getHobby());
        userDetailsDTO.setMaritalStatus(userDetailsEntity.getMaritalStatus());
        userDetailsDTO.setListOfTechnologies(userDetailsEntity.getListOfTechnologies());
        userDetailsDTO.setUser(userDetailsEntity.getUser());

        return  userDetailsDTO;
    }
    private  UserDetailsEntity dtoToEntityMapper(UserDetailsDTO userDetailsDTO){
        UserDetailsEntity userDetailsEntity=new UserDetailsEntity();
        userDetailsEntity.setId(userDetailsDTO.getId());
        userDetailsEntity.setUser(userDetailsDTO.getUser());
        userDetailsEntity.setDateOfBirth(userDetailsDTO.getDateOfBirth());
        userDetailsEntity.setEmail(userDetailsDTO.getEmail());
        userDetailsEntity.setHobby(userDetailsDTO.getHobby());
        userDetailsEntity.setMaritalStatus(userDetailsDTO.getMaritalStatus());
        userDetailsEntity.setListOfTechnologies(userDetailsDTO.getListOfTechnologies());

        return  userDetailsEntity;
    }
    }
