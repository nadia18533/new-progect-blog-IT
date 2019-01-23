package com.example.demo.service.impl.impl;

import com.example.demo.domain.CommentDTO;
import com.example.demo.entity.CommentEntity;
import com.example.demo.repository.CommentRepository;
import com.example.demo.service.impl.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl  implements CommentService {

    @Autowired
    private CommentRepository commentRepository;


    @Override
    public void saveComment(CommentDTO comment) {


        CommentEntity commentEntity=new CommentEntity();
        commentEntity.setComment(comment.getComment());
        commentRepository.save(commentEntity);
    }

    @Override
    public List<CommentDTO> findAllComments() {
        List<CommentEntity>comments=commentRepository.findAll();
        List<CommentDTO>commentDTOS=new ArrayList<>();

        for(CommentEntity entity:comments){
            CommentDTO commentDTO=entityToDTOMapper(entity);
            commentDTOS.add(commentDTO);
        }
        return commentDTOS;
    }

    @Override
    public CommentDTO findCommentById(int id) {
        boolean exists=commentRepository.existsById(id);
        if(!exists){
            return  null;
        }
        CommentEntity comments=commentRepository.findById(id).get();

        return entityToDTOMapper(comments);
    }

    @Override
    public CommentDTO updateComment(int id, CommentDTO commentToUpdate) {
        boolean exists=commentRepository.existsById(id);
        if(!exists){

            return  null;
        }
        CommentEntity commentFromDB=commentRepository.findById(id).get();
        commentFromDB=dtoToEntityMapper(commentToUpdate);
        commentRepository.save(commentFromDB);
        commentToUpdate.setId(commentFromDB.getId());

        return commentToUpdate;
    }
    private CommentDTO entityToDTOMapper(CommentEntity commentEntity){
        CommentDTO commentDTO=new CommentDTO();
        commentDTO.setId(commentEntity.getId());
        commentDTO.setComment(commentEntity.getComment());

        return  commentDTO;
    }
    private  CommentEntity dtoToEntityMapper(CommentDTO commentDTO){
        CommentEntity commentEntity= new CommentEntity();
        commentEntity.setId(commentDTO.getId());
        commentEntity.setComment(commentDTO.getComment());

        return  commentEntity;

    }



}

