package com.example.demo.domain;


import com.example.demo.entity.CommentEntity;
import com.example.demo.entity.TagEntity;
import com.example.demo.entity.UserEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PostDTO {
    private int id;
    private String tittle;
    private String description;
    private String dateOfCreate;
    private UserEntity user;
    private List<CommentEntity> comments;
    private  List<TagEntity>tags;

}
