package com.example.demo.domain;

import com.example.demo.entity.TagEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor
public class TagDTO extends TagEntity {

    private int id;
    private String nameOfTag;

}
