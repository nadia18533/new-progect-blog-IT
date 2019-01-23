package com.example.demo.controller;

import com.example.demo.domain.UserDTO;
import com.example.demo.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;



    @PostMapping
    public ResponseEntity<?> createUser(
            @RequestBody UserDTO userDTO
    ){

        System.out.println(
                userDTO.getName()+" "+
                        userDTO.getSecondName()+ " "+
                        userDTO.getNickname()+ " "+
                        userDTO.getDateOfCreate()
        );
        userService.saveUser(userDTO);
        return  new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public  ResponseEntity<?>getUsers(){
        List<UserDTO> users=userService.findAllUsers();
        return  new ResponseEntity<>(users,HttpStatus.OK);
    }

    @GetMapping("{userId:[0-9]{1,5}}")
    public  ResponseEntity<?>getUserById(@PathVariable("userId")int id){
        UserDTO user=userService.findUserById(id);
        if (user==null){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity<>(user,HttpStatus.OK);
    }

    @PutMapping("{userId:[0-9]{1,5}}")
    public  ResponseEntity<?>updateUser(
            @PathVariable("userId")int id,@RequestBody UserDTO userToUpdate
    ){
        UserDTO user=userService.updateUser(id,userToUpdate);

        if (user==null){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return  new ResponseEntity<>(user,HttpStatus.OK);
    }

}
