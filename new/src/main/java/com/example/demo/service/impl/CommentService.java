package com.example.demo.service.impl;

import com.example.demo.domain.CommentDTO;

import java.util.List;

public interface CommentService {
    void saveComment(CommentDTO comment);


    List<CommentDTO> findAllComments();

    CommentDTO findCommentById(int id);

    CommentDTO updateComment(int id,CommentDTO commentToUpdate);
}


