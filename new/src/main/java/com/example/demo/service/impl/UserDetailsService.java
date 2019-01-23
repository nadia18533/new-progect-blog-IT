package com.example.demo.service.impl;

import com.example.demo.domain.UserDetailsDTO;

import java.util.List;

public interface UserDetailsService {

    void saveUserDetail(UserDetailsDTO userDetail) ;

    List<UserDetailsDTO> findAllUserDetails();

    UserDetailsDTO findUserDetailById(int id);

    UserDetailsDTO updateUserDetails(int id, UserDetailsDTO userDetailsToUpdate);

}
