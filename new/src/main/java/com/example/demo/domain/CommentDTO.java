package com.example.demo.domain;


import com.example.demo.entity.CommentEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor
public class CommentDTO extends CommentEntity {
    private int id;
    private String comment;
}
